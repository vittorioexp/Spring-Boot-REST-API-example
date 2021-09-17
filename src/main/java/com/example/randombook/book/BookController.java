package com.example.randombook.book;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/test")
    public String findOne() {
        return "RANDOM BOOK";
    }
}
