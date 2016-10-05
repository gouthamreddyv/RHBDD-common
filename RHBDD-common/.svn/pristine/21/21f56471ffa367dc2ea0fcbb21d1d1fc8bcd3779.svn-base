package net.tao.rhb.dd.dao;

import net.tao.rhb.dd.commons.ibg.format.BatchHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.EntryDetailFormat;
import net.tao.rhb.dd.commons.ibg.format.FileHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.FirstAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.ReturnAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.SecondAddendaFormat;

public interface IbgFileDao {
    
    long addIbgFile(FileHeaderFormat fileHeaderFormat); 
    
    long addIbgFileBatch(BatchHeaderFormat batchHeaderFormat);
    
    long addIbgFileEntry(EntryDetailFormat entryDetailFormat);
    
    long addIbgFirstAddenda(FirstAddendaFormat firstAddendaFormat);

    long addIbgSecondAddenda(SecondAddendaFormat secondAddendaFormat);
    
    long addIbgReturnAddenda(ReturnAddendaFormat returnAddendaFormat);
}
