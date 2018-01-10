package com.maventutorials.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Author: Shreya Hedau : shreya.hedau
 * Date: 28-Nov-17
 */

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


	/**
	 * Detect URL and redirect as per User Type
	 *
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		String targetUrl = determineTargetUrl(authentication, request);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * This method extracts the roles of currently logged-in user and returns
	 * appropriate URL according to his/her role.
	 *
	 * @param authentication
	 * @return
	 */
	protected String determineTargetUrl(Authentication authentication, HttpServletRequest request) {
		Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(authorities);
		if(authorities.contains("ROLE_USER")) {
			return "/userLoginSuccess";
		}
		else if (authorities.contains("ROLE_ADMIN"))
		{
			return "/adminLoginSuccess";
		}else
		{
			return "/login";
		}

	}

	@Override
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	@Override
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

}
