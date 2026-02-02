package ru.wolfram.server

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1")
class ButtonController {
    @GetMapping("/buttons")
    fun buttons(): String {
        return "buttons"
    }

    @GetMapping("/task1")
    fun task1(): String {
        return "task1"
    }
}