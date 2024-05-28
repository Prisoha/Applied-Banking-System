package com.abs.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
	
	 READ("read"),
	 CREATE("create"),
	 UPDATE("update"),
	 DELETE("delete");
	
    @Getter
    private final String permission;
}
