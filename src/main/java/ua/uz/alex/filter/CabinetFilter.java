package ua.uz.alex.filter;

import ua.uz.alex.domain.UserRole;
import ua.uz.alex.shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/cabinet.jsp")
public class CabinetFilter implements javax.servlet.Filter {
    private FilterService filterService = FilterService.getFilterService();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        filterService.doFilterValidation(req, resp, chain, Arrays.asList(UserRole.USER, UserRole.ADMINISTRATOR));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
