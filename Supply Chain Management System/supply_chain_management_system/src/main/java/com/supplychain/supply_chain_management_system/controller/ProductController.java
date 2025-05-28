package com.supplychain.supply_chain_management_system.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.model.Order;
import com.supplychain.supply_chain_management_system.model.Product;
import com.supplychain.supply_chain_management_system.service.OrderService;
import com.supplychain.supply_chain_management_system.service.ProductService;
import com.supplychain.supply_chain_management_system.service.UserService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

     @Autowired
    private OrderService orderService;


    // Show all products
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list"; // JSP page for listing products
    }

    
    // Show form to add a new product
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-add"; // JSP page for adding products
    }

    // Process adding a new product
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, Principal principal) {
        // Get logged in user (farmer)
        String username = principal.getName();
        AppUser farmer = userService.findByUsername(username);
        product.setFarmer(farmer);

        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Delete product by ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    // Show product details (optional)
    @GetMapping("/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product-details"; // JSP page for product details
    }

    @GetMapping("/farmer/orders")
    public String viewFarmerOrders(Principal principal, Model model) {
        String farmerUsername = principal.getName();
        List<Order> orders = orderService.getOrdersForFarmer(farmerUsername);
        model.addAttribute("orders", orders);
        return "farmer_orders"; // JSP to view orders received by farmer
    }

    @PostMapping("/farmer/order/ship")
    public String markOrderShipped(@RequestParam("orderId") Long orderId) {
        orderService.markAsShipped(orderId);
        return "redirect:/farmer/orders";
    }


}

