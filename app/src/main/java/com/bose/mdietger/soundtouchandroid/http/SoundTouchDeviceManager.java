package com.bose.mdietger.soundtouchandroid.http;

import android.util.Log;

import com.bose.mdietger.soundtouchandroid.soundtouch.SoundTouch;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

/**
 * SoundTouchDeviceManager class. This class is reponsible for interactions
 * with the SoundTouch devices.
 */
public class SoundTouchDeviceManager implements DeviceManager {

    private static final String TAG = "SoundTouchDeviceManager";
    private static final String PORT = "8090";

    private SoundTouch device;

    private AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Instantiates a new SoundTouchDeviceManager.
     * @param device the device to manage
     */
    public SoundTouchDeviceManager(SoundTouch device) {
        this.device = device;
        this.client = new AsyncHttpClient();
    }

    @Override
    public void setVolume(String volumeLevel) {
        StringEntity data = null;
        try {
            data = new StringEntity(volumeLevel);
            data.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Error occured: " + e.getMessage());
            return;
        }

        client.post(null, getAbsoluteUrl("/volume"), data, "application/xml", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("STApp", "Success");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("STApp", "Failed");
            }

        });
    }

    /**
     * Returns the absolute url.
     * @param path the path
     * @return String the absolute url
     */
    String getAbsoluteUrl(String path) {
        return "http://" + device.get_ip() + ":" + PORT + path;
    }

}