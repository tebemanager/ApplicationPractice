package com.application.practice.xml_pdf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practice.databinding.XmlPdfBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Charles Raj I on 23/07/22.
 *
 * @author Charles Raj I
 */
public class XmlToPdf extends AppCompatActivity  {


    // using view binding so i'm implemnt ing the layout like this.
    // see my last mvvm video to implement the viewbinding.
    private XmlPdfBinding xmlPdfBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        xmlPdfBinding = XmlPdfBinding.inflate(getLayoutInflater());
        setContentView(xmlPdfBinding.getRoot());
        /*To use the xml view in view binding need to define the id in xml */
        xmlPdfBinding.pdfButton.setOnClickListener(view -> {
           /*Lets start coding here how to convert the xml layout to pdf.
           * for the first we need to load the layout to Bitmap..
           * lets do that --> convert the pdfLayout to bitmap...
           * */
            Bitmap bitmap = viewToBitmap(xmlPdfBinding.pdfLayout,xmlPdfBinding.pdfLayout.getWidth(),xmlPdfBinding.pdfLayout.getHeight());
            createPdf(bitmap);
        });

        xmlPdfBinding.openPDf.setOnClickListener(view -> {

            OpenCreatedFile();
        });
    }



    /* This method is use to convert the view to bitmap
    * In bitmap we need to provide HEIGHT, WIDTH, COLOR ALOGRITHM
    * params @v = View, @Width = width of the pdf view @height = height of the pdf view
    *  */
    public static Bitmap viewToBitmap(View v,int width, int height){
        Bitmap viewMap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(viewMap);
        v.draw(canvas);
        /*process is done..  returing the bitmap*/
        return viewMap;
    }


    /*Lets start creating the pdf using this function
    * @params  @bitmap= Bitmap
    * */
    public void createPdf(Bitmap bitmap){
        /*First get the height and width of the pdf
        * */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float heigh = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        int mheight = (int) heigh, mwidth = (int) width;

        /* Started createing a pdf from here....
        * */
        PdfDocument document = new PdfDocument();
        /* You can specify the page count here and height and width of the page count
        * this is the layout height and width
        * if you need A4 size .. USE 594 and 842
        * */
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(mheight,mwidth,1).create();
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        canvas.drawPaint(paint);

        //        A4 size .. USE 594 and 842
        bitmap = Bitmap.createScaledBitmap(bitmap,mwidth,mheight,true);

        paint.setColor(Color.BLUE);

        canvas.drawBitmap(bitmap, 0,0,null);
        document.finishPage(page);

        try {

            /*Need to specify the pathb ...
            * Lets get that from the specific method ... */
            document.writeTo(getFileName());
        }catch (Exception e){
            Log.d("TAG", "createPdf: " + e.getMessage());
        }
    }
    /* To get the file path to store the pdf file
    * */
    public FileOutputStream getFileName(){
        File pdfDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ "/PDF");
        if (!pdfDir.exists()) pdfDir.mkdir();
        File myPath = new File(pdfDir, "cmlPdf" + ".pdf");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
        }catch (Exception ee){
            Log.d("TAG", "getFileName: " + ee.getMessage());
        }
        return fos;
    }

    public void OpenCreatedFile(){
        File pdfDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ "/PDF");
        if (!pdfDir.exists()) pdfDir.mkdir();
        File myPath = new File(pdfDir, "cmlPdf" + ".pdf");
        if (myPath.exists()){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.putExtra(Intent.EXTRA_TEXT, "OpenPDF");
            intent.setType("application.pdf");

            Intent shareIntent = Intent.createChooser(intent,null);
            startActivity(shareIntent);

        }
    }
}
