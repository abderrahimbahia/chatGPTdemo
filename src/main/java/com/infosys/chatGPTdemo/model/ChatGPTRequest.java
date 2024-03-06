package com.infosys.chatGPTdemo.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTRequest {

    private String model = "gpt-3.5-turbo-instruct";
    private String prompt;
    private int temperature = 1;

    @SerializedName(value = "max_tokens")
    private int maxTokens = 1000;
}
