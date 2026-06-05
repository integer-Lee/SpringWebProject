package org.zerock.ex00.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Restaurant {
    private final Chef chef;

}
