package com.italianDudes.dnd_extension.common;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.DnDSheetPreview;
import com.italianDudes.gvedk.common.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@SuppressWarnings("unused")
public class SheetHandler {

    public static HashMap<DnDSheetPreview, File> getUserSheets(String userDirectoryFile){
        return getUserSheets(new File(userDirectoryFile));
    }
    public static HashMap<DnDSheetPreview, File> getUserSheets(File userDirectory){

        HashMap<DnDSheetPreview, File> sheetsMap = new HashMap<>();

        File[] directoryMap = userDirectory.listFiles(pathname -> {
            try {
                int directoryNumber = Integer.parseInt(pathname.getName());
                return directoryNumber>= DnD_Extension.Defs.SHEET_ID_MIN && directoryNumber< DnD_Extension.Defs.SHEET_ID_MAX && pathname.isDirectory();
            }catch (Exception e){
                return false;
            }
        });

        if(directoryMap==null)
            return null;

        DnDSheetPreview[] sheetPreviews = new DnDSheetPreview[directoryMap.length];
        for(int i=0;i<sheetPreviews.length;i++){
            try {
                sheetPreviews[i] = DnDSheetPreview.readPreview(directoryMap[i]);
            }catch (IOException e){
                Logger.log(e);
                sheetPreviews[i] = null;
            }
        }

        for(int i=0;i<directoryMap.length;i++){
            sheetsMap.put(sheetPreviews[i],directoryMap[i]);
        }

        return sheetsMap;

    }

}
