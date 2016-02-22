/*     */ package org.textbug.utility;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileUtil
/*     */ {
/*  27 */   private static Logger logger = Logger.getLogger(FileUtil.class);
/*     */   
/*     */   public static synchronized void deleteFiles(String directory) {
/*  30 */     File f1 = new File(directory);
/*     */     
/*  32 */     if (f1.isDirectory()) {
/*  33 */       List<String> l = getFilesInDirectory(directory);
/*  34 */       for (String file : l)
/*     */       {
/*  36 */         boolean success = new File(file).delete();
/*  37 */         if (!success) {
/*  38 */           logger.warn("Problem deleting" + file);
/*     */         } else {
/*  40 */           logger.info("Success deleting" + file);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List getChildDirectories(String dirName)
/*     */   {
/*  55 */     List<String> files = new ArrayList();
/*  56 */     File dir = new File(dirName);
/*     */     
/*  58 */     String[] children = dir.list();
/*  59 */     if (children != null)
/*     */     {
/*     */ 
/*  62 */       for (int i = 0; i < children.length; i++)
/*     */       {
/*  64 */         String filename = dirName + System.getProperty("file.separator") + children[i];
/*  65 */         if (new File(filename).isDirectory()) {
/*  66 */           files.add(filename);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */     return files;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getDirectoryOfFile(String file)
/*     */   {
/* 102 */     return new File(file).getParent();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List getFilesInDirectory(String dirName)
/*     */   {
/* 110 */     List<String> files = new ArrayList();
/* 111 */     File dir = new File(dirName);
/*     */     
/* 113 */     String[] children = dir.list();
/* 114 */     if (children != null)
/*     */     {
/*     */ 
/* 117 */       for (int i = 0; i < children.length; i++)
/*     */       {
/* 119 */         String filename = children[i];
/* 120 */         files.add(dirName + System.getProperty("file.separator") + filename);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 145 */     return files;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static List getFilesInDirectory(String dirName, String fileType)
/*     */   {
/* 152 */     List<String> files = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */     File dir = new File(dirName);
/* 170 */     FilenameFilter filter = new FilenameFilter() {
/*     */       public boolean accept(File dir, String name) {
/* 172 */         if (name.endsWith(FileUtil.this))
/* 173 */           return true;
/* 174 */         return false;
/*     */       }
/* 176 */     };
/* 177 */     String[] children = dir.list(filter);
/*     */     
/* 179 */     for (int i = 0; i < children.length; i++)
/*     */     {
/* 181 */       String filename = children[i];
/* 182 */       files.add(dirName + System.getProperty("file.separator") + filename);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 193 */     return files;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized BufferedReader getReader(String strAbsPathToFile)
/*     */     throws IOException
/*     */   {
/* 203 */     BufferedReader br = null;
/* 204 */     br = new BufferedReader(new FileReader(strAbsPathToFile));
/* 205 */     return br;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized BufferedReader getResourceFromPackage(String strAbsPathToFile)
/*     */     throws Exception
/*     */   {
/* 217 */     BufferedReader br = null;
/* 218 */     ClassLoader classLoader = Thread.currentThread()
/* 219 */       .getContextClassLoader();
/* 220 */     InputStream is = classLoader.getResourceAsStream(strAbsPathToFile);
/*     */     
/* 222 */     if (is == null) {
/* 223 */       throw new Exception("File '" + strAbsPathToFile + 
/* 224 */         "' is missing in classpath.");
/*     */     }
/*     */     
/* 227 */     br = new BufferedReader(new InputStreamReader(is));
/*     */     
/* 229 */     return br;
/*     */   }
/*     */   
/*     */   public static synchronized BufferedWriter getWriter(String strFile) throws IOException
/*     */   {
/* 234 */     BufferedWriter br = null;
/* 235 */     br = new BufferedWriter(new FileWriter(strFile));
/* 236 */     return br;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isFileExists(String file)
/*     */   {
/* 245 */     return new File(file).exists();
/*     */   }
/*     */   
/*     */   public static void createDir(String dir) {
/* 249 */     File f = new File(dir);
/* 250 */     if (!f.exists()) {
/* 251 */       f.mkdirs();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void parseFileName(String fileName, String delimeter, HashMap<String, String> map)
/*     */   {
/* 269 */     int idx = fileName.lastIndexOf('.');
/* 270 */     if (idx > 0) {
/* 271 */       String str1 = fileName.substring(idx, fileName.length());
/*     */     }
/*     */     
/*     */ 
/* 275 */     fileName = fileName.substring(0, idx);
/*     */     
/* 277 */     String[] nvPairs = fileName.split(delimeter);
/* 278 */     if (nvPairs.length > 0)
/*     */     {
/*     */ 
/* 281 */       for (int i = 0; i < nvPairs.length; i++) {
/* 282 */         idx = nvPairs[i].indexOf('=');
/*     */         
/* 284 */         if (idx < 0) {
/* 285 */           System.err.println(fileName);
/*     */         }
/*     */         
/* 288 */         String name = nvPairs[i].substring(0, nvPairs[i].indexOf('='));
/* 289 */         String value = nvPairs[i].substring(nvPairs[i].indexOf('=') + 1, nvPairs[i].length());
/*     */         
/* 291 */         map.put(name, value);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\FileUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */