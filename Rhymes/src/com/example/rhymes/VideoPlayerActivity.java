package com.example.rhymes;

import java.io.IOException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

public class VideoPlayerActivity extends ActionBarActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, VideoControllerView.MediaPlayerControl {

    SurfaceView videoSurface;
    MediaPlayer player;
    VideoControllerView controller;
    ProgressDialog progressDialog;
    String urltoplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_video_player);
        Bundle get = getIntent().getExtras();
        if(get!=null)
        {
        	urltoplay = get.getString("urltoplay");//
        	Log.i("Url to play",""+urltoplay);
        }
        
        videoSurface = (SurfaceView) findViewById(R.id.videoSurface);
        SurfaceHolder videoHolder = videoSurface.getHolder();
        videoHolder.addCallback(this);
        progressDialog = ProgressDialog.show(VideoPlayerActivity.this, "", "Buffering video...", true);
        progressDialog.setCancelable(true);  
        player = new MediaPlayer();
        controller = new VideoControllerView(this);
//        {
//        	@Override
//        	public void hide()
//        	{
//        		super.show();
//        	}
//        };
        
        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(this, Uri.parse(urltoplay));
            player.setOnPreparedListener(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        controller.show();
        return false;
    }

    // Implement SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    	player.setDisplay(holder);
        player.prepareAsync();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        
    }
    // End SurfaceHolder.Callback

    // Implement MediaPlayer.OnPreparedListener
    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setAnchorView((FrameLayout) findViewById(R.id.videoSurfaceContainer));
        
        progressDialog.dismiss();
        player.start();
    }
    // End MediaPlayer.OnPreparedListener

    // Implement VideoMediaController.MediaPlayerControl
    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return player.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return player.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return player.isPlaying();
    }

    @Override
    public void pause() {
        player.pause();
    }

    @Override
    public void seekTo(int i) {
        player.seekTo(i);
    }

    @Override
    public void start() {
        player.start();
    }

    @Override
    public boolean isFullScreen() {
        return false;
    }

    @Override
    public void toggleFullScreen() {
        
    }
    // End VideoMediaController.MediaPlayerControl

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (player != null) 
		player.release();
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      
        // Handle action buttons
        switch(item.getItemId()) {
        case android.R.id.home:
            // app icon in action bar clicked; go home
        	finish();
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
            return true;
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
