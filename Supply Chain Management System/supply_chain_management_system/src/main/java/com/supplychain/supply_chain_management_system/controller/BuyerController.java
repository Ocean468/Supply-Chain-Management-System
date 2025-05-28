package com.supplychain.supply_chain_management_system.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supplychain.supply_chain_management_system.model.Order;
import com.supplychain.supply_chain_management_system.model.Product;
import com.supplychain.supply_chain_management_system.service.OrderService;
import com.supplychain.supply_chain_management_system.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BuyerController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/buyer/dashboard")
    public String buyerDashboard() {
        return "buyer-dashboard"; // Will resolve to buyer-dashboard.jsp
    }

    @GetMapping("/buyer/products")
    public String browseProducts(Model model) {
        // Add product list to model
        model.addAttribute("products", productService.getAllProducts());
        return "buyer_products"; // JSP page to list products
    }

    // @GetMapping("/order/place")
    // public String placeOrder() {
    //     return "place_order"; // JSP page to place order
    // }


    // @GetMapping("/order/place")
    // public String showOrderForm(@RequestParam("productId") Long productId, Model model) {
    //     Product product = productService.getProductById(productId);
    //     model.addAttribute("product", product);
    //     return "place_order"; // JSP page to show product and form
    // }


   @GetMapping("/order/place")
public String showOrderForm(@RequestParam(value = "productId", required = false) Long productId,
                            Model model,
                            HttpServletRequest request) {

    if (productId == null) {
        return "redirect:/buyer/products";
    }

    Product product = productService.getProductById(productId);
    model.addAttribute("product", product);

    // Add CSRF token to the model
    CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
    model.addAttribute("_csrf", csrfToken);

    return "place_order";
}




    @PostMapping("/order/submit")
    public String submitOrder(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") int quantity,
            Principal principal
    ) {
        String buyerUsername = principal.getName();
        orderService.placeOrder(buyerUsername, productId, quantity);
        return "redirect:/buyer/orders"; // Redirect to view orders
    }


    @GetMapping("/buyer/orders")
    public String viewOrders(Principal principal, Model model) {
        String buyerUsername = principal.getName();
        List<Order> orders = orderService.getOrdersForBuyer(buyerUsername);
        model.addAttribute("orders", orders);
        return "buyer_orders"; // JSP page to show order history
    }



}

