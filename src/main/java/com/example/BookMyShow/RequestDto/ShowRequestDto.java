package com.example.BookMyShow.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequestDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private  String movieName;

    private int theatreId;

    private double multiplier;

}