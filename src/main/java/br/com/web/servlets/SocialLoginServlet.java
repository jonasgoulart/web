package br.com.web.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.Profile;
import org.brickred.socialauth.SocialAuthManager;
import org.brickred.socialauth.util.SocialAuthUtil;

import br.com.web.constants.AccountOriginEnum;
import br.com.web.constants.StatusUserEnum;
import br.com.web.constants.UserTypeEnum;
import br.com.web.dao.UserDAO;
import br.com.web.domain.User;
import br.com.web.utils.SocialUtils;

@WebServlet("/social/login")
public class SocialLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = -8141169124278826240L;
	public static final String SERVLET_URL = SocialUtils.BASE_URL + "/social/login";

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try{
				HttpSession session = req.getSession();
    
				SocialAuthManager socialAuthManager = (SocialAuthManager) session.getAttribute("authManager");
    
				if(socialAuthManager != null)
				{
					Map<String, String> paramsMap = SocialAuthUtil.getRequestParametersMap(req);
			
					AuthProvider provider;

					provider = socialAuthManager.connect(paramsMap);
					
					Profile socialProfile = provider.getUserProfile();
        			
					session.setAttribute("authManager", null);
					
					
					if(socialProfile != null && socialProfile.getEmail() != null)
					{						
						User user = new User();
						user.setUrlImage(socialProfile.getProfileImageURL());
						user.setOrigin(AccountOriginEnum.FACEBOOK);
						user.setName(socialProfile.getFullName());
						user.setEmail(socialProfile.getEmail());
						user.setStatus(StatusUserEnum.A);
						user.setType(UserTypeEnum.C);
						
						user = (User) new UserDAO().save(user);
						
						if(user != null)
						{
							session.setAttribute("user", user);
						
						}else{
							
								session.setAttribute("user", user);
						}
					}
				}
				
				resp.sendRedirect(SocialUtils.BASE_URL);
			
		}catch (Exception e){
					
			e.printStackTrace();
			
			resp.sendRedirect(SocialUtils.BASE_URL);
		}
	}
}