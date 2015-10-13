/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.esn.conversetionsdecoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author scraelos
 */
public class Decoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        List<Location> result = LuaDecoder.decode(path);
        FileOutputStream fileOut = new FileOutputStream("conversations.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("Conversations");
        HSSFRow newRow;
        HSSFCell newCell;
        for (Location loc : result) {
            addRow("Локация", loc.getName(), worksheet);
            for (Npc npc : loc.getNpcs()) {
                addRow("NPC", npc.getName(), worksheet);
                for (Greeting greeting : npc.getGreetings()) {
                    addRow("Приветствие_" + greeting.getNum(), greeting.getText(), worksheet);
                }
                for (Subtitle subtitle : npc.getSubtitles()) {
                    addRow("Субтитры", subtitle.getText(), worksheet);
                }
                for(Topic topic:npc.getTopics()) {
                    addRow("фраза игрока:",topic.getPlayerText(), worksheet);
                    addRow("фраза NPC:",topic.getNpcText(), worksheet);
                }
            }
        }
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    private static void addRow(String rowType, String rowContent, HSSFSheet worksheet) {
        HSSFRow newRow;
        HSSFCell newCell;
        newRow = worksheet.createRow(worksheet.getPhysicalNumberOfRows());
        newCell = newRow.createCell(0, HSSFCell.CELL_TYPE_STRING);
        newCell.setCellValue(rowType);
        newCell = newRow.createCell(1, HSSFCell.CELL_TYPE_STRING);
        newCell.setCellValue(rowContent);
    }

}
