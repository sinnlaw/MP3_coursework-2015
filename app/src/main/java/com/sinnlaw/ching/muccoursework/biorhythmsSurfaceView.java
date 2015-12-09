package com.sinnlaw.ching.muccoursework;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ching on 2015/12/02.
 */
public class biorhythmsSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder shBioSurface;

    biorhythmsThread drawingThread = null;


    public biorhythmsSurfaceView(bioActivity context)
    {
        super(context);
        shBioSurface = getHolder();
        shBioSurface.addCallback(this);
        drawingThread = new biorhythmsThread(getHolder(), this);
        setFocusable(true);

    }

    public biorhythmsThread getThread()
    {
        return drawingThread;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {

        drawingThread.setRunning(true);
        drawingThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        drawingThread.setSurfaceSize(width,height);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        drawingThread.setRunning(false);
        while(retry)
        {
            try {
                drawingThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
