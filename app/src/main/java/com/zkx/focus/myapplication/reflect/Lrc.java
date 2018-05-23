package com.zkx.focus.myapplication.reflect;

import java.util.Date;

public class Lrc {
    private String lrcName;
    private Integer lrcSize;
}


class Mp3 {
    private String mp3Name;
    private int mp3Size;
}

class Resource {
    private String id;
    private Mp3 mp3;
    private Lrc lrc;
    private Date date;
}  