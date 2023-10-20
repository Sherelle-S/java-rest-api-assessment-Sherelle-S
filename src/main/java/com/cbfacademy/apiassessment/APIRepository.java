package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class APIRepository {

    @Autowired
    // APIRepository

    @GetMapping("/Post")
    public List<Post> getAllPost()
    {}
}
