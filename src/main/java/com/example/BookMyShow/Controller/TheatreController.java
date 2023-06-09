package com.example.BookMyShow.Controller;


import com.example.BookMyShow.Models.TheatreEntity;
import com.example.BookMyShow.RequestDto.TheatreRequestDto;
import com.example.BookMyShow.ResponseDto.ShowEntityResponseDto;
import com.example.BookMyShow.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;


    @PostMapping("/add")
    public ResponseEntity<String> addTheatre(@RequestBody() TheatreRequestDto theatreRequestDto){

        theatreService.createTheatre(theatreRequestDto);

        return new ResponseEntity<>("Theatre created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-theatreList-where-movie-is-there")
    public ResponseEntity<List<String>> getAllTheatreList(@RequestParam("movieName") String movieName){
        List<String> theatreList= theatreService.getAllTheatreList(movieName);
        return new ResponseEntity<>(theatreList,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-theatres")
    public ResponseEntity<List<TheatreResponseDto>> getAllTheatres(){
        List<TheatreResponseDto> theatreResponseDtoList= theatreService.getAllTheatres();
        return new ResponseEntity<>(theatreResponseDtoList, HttpStatus.FOUND);
    }

    @GetMapping("/get-theatre-by-id/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatreById(@PathVariable("id") int id){
        TheatreResponseDto theatreResponseDto = theatreService.getTheatreById(id);
        return new ResponseEntity<>(theatreResponseDto,HttpStatus.FOUND);
    }

    @GetMapping("/get-showsList-in-theatre/{id}")
    public ResponseEntity<List<ShowEntityResponseDto>> getShowListInTheatreByTheatreId(@PathVariable("id") int id){

        List<ShowEntityResponseDto> showEntityResponseDto= theatreService.getShowListInTheatreByTheatreId(id);
        return new ResponseEntity<>(showEntityResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/get-showsList-in-theatre-by-theatreName/{name}")
    public ResponseEntity<List<ShowEntityResponseDto>> getShowListInTheatreByTheatreName(@PathVariable("name") String name){

        List<ShowEntityResponseDto> showEntityResponseDto= theatreService.getShowListInTheatreByTheatreName(name);
        return new ResponseEntity<>(showEntityResponseDto, HttpStatus.FOUND);
    }

}