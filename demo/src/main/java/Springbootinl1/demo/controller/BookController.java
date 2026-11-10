package Springbootinl1.demo.controller;

import Springbootinl1.demo.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class BookController {
    @GetMapping("/welcome")
    public String dateAndGreeting(Model model){
        Date date  = new Date();
        model.addAttribute("date",date);

        String greeting = "Welcome buddy!, the time is: ";
        model.addAttribute("greeting",greeting);
        return  "home";
    }

    @GetMapping("/books")
    public String listOfBooks(Model model){
        List<Book> bookList = List.of(
                new Book("Book of Iran","Nahid","Thriller"),
                new Book("Book of Sweden","Hampus","Romance"),
                new Book("Book of Rasht","Sadra","Action"),
                new Book("Book of Romania","Ameer","Drama")
        );

        model.addAttribute("books",bookList);

        return "booklist";
    }

    @GetMapping("/search")
    public  String Search(){
        return "genre-form";
    }

    @GetMapping("/genre")
        public String genreFilter(@RequestParam String genre, Model model ){
        List<Book> bookList = Stream.of(
                new Book("Book of Iran","Nahid","Thriller"),
                new Book("Book of Sweden","Hampus","Romance"),
                new Book("Book of Rasht","Sadra","Action"),
                new Book("Book of Romania","Ameer","Drama")
        ).filter(book -> book.getGenre().equalsIgnoreCase(genre.trim())).toList();

        model.addAttribute("books",bookList);
        model.addAttribute("pickedGenre", genre);
        return "genre";
    }




}
