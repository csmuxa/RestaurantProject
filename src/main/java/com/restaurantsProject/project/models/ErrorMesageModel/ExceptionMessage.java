package com.restaurantsProject.project.models.ErrorMesageModel;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionMessage {
    String reason;
    Date date;
}
