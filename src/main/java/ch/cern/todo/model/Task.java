package ch.cern.todo.model;

import org.springframework.data.annotation.Id;

public record Task (@Id Integer taskId, String taskName, String taskDescrition, String timeStamp){
}

