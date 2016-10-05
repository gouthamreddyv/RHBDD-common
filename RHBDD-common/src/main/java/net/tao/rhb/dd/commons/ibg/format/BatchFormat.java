package net.tao.rhb.dd.commons.ibg.format;

import java.util.ArrayList;
import java.util.List;

public class BatchFormat {

    public BatchHeaderFormat batchHeaderFormat = new BatchHeaderFormat();

    public List<EntryDetailFormat> entries = new ArrayList<>();

    public BatchControlFormat batchControlFormat = new BatchControlFormat();


    @Override
    public String toString() {
        return "BatchFormat{" 
               + "batchHeaderFormat=" + batchHeaderFormat 
               + ", entries=" + entries 
               + ", batchControlFormat=" + batchControlFormat 
               + '}';
    }
}
