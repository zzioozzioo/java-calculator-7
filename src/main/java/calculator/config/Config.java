package calculator.config;

import calculator.io.reader.MissionUtilsReader;
import calculator.io.reader.Reader;
import calculator.io.writer.SystemWriter;
import calculator.io.writer.Writer;

public class Config {

    private final Reader reader;
    private final Writer writer;


    public Config() {
        this.reader = new MissionUtilsReader();
        this.writer = new SystemWriter();

    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }
}
