package com.zany.hwdetail;

import java.util.ArrayList;
import java.util.Hashtable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MonHwPopupDetail extends RelativeLayout {

	private final String TAG = this.getClass().getSimpleName();
	private Context mContext;

	private ArrayList<HighwayInfo> mArrHighwayInfo;
	private final String GRADE_CR = "CR";
	private final String GRADE_MJ = "MJ";
	private final String GRADE_MI = "MI";
	private final String GRADE_NR = "NR";
	
	private final AreaMargin mAreaMargin;
	private final int mBaseWidth;
	private final int mBaseHeight;

	private Point AREA_SRT = new Point();  // �� VIEW �� ǥ�õǴ� ������ ���� x,y ��ǥ
	private Point AREA_END = new Point();  // �� VIEW �� ǥ�õǴ� ������ ���� x,y ��ǥ

	private int mScrWidth;
	private int mScrHeight;
	
	private boolean mShow;
	
	public MonHwPopupDetail(Context context, int scrWidth, int scrHeight) {
		
		super(context);
		
		this.mContext   = context;
		this.mScrWidth  = scrWidth;
		this.mScrHeight = scrHeight;
		this.mShow = false;

		mAreaMargin = new AreaMargin(25, 45, 25, 35); // L,T,R,B
		mBaseWidth  = mScrWidth  - (mAreaMargin.getLeft() + mAreaMargin.getRight());
		mBaseHeight = mScrHeight - (mAreaMargin.getTop()  + mAreaMargin.getBottom());

		this.AREA_SRT.set(0, 0);
		this.AREA_END.set(0, 0);
		
		mArrHighwayInfo = new ArrayList<HighwayInfo>();
//		mArrHighwayInfo.add(new HighwayInfo("101001", "��ΰ�ӱ�������", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101003", "�λ�T.G", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101004", "����IC", GRADE_NR));
		mArrHighwayInfo.add(new HighwayInfo("101005", "���Jct", GRADE_MI));
		mArrHighwayInfo.add(new HighwayInfo("101007", "�뵵��IC", GRADE_MI));
		mArrHighwayInfo.add(new HighwayInfo("101008", "�����IC", GRADE_MJ));
		mArrHighwayInfo.add(new HighwayInfo("101009", "���Jct", GRADE_CR));
		mArrHighwayInfo.add(new HighwayInfo("101011", "��õIC", GRADE_MI));
//		mArrHighwayInfo.add(new HighwayInfo("101012", "��õIC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101014", "���뱸Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101015", "����Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101016", "�ϴ뱸IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101018", "�ְ�IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101019", "������IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101020", "����IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101022", "��õIC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101023", "��ǳ��IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101024", "Ȳ��IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101026", "�ݰ�IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101027", "��õIC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101029", "����IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101030", "ȸ��Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101031", "��ź��IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101033", "û��Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101034", "����Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101035", "û��IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101037", "õ��Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101038", "õ��IC", GRADE_MJ));
//		mArrHighwayInfo.add(new HighwayInfo("101039", "�ȼ�IC", GRADE_CR));
//		mArrHighwayInfo.add(new HighwayInfo("101041", "����IC", GRADE_MJ));
//		mArrHighwayInfo.add(new HighwayInfo("101042", "����IC", GRADE_MI));
//		mArrHighwayInfo.add(new HighwayInfo("101044", "�Ű�Jct", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101045", "����T.G", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101046", "�Ǳ�IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101048", "�޷�����(��)", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101049", "����IC", GRADE_NR));
//		mArrHighwayInfo.add(new HighwayInfo("101050", "����IC", GRADE_NR));
		
	}
	
	public Point getAreaSrt() {
		return this.AREA_SRT;
	}
	
	public Point getAreaEnd() {
		return this.AREA_END;
	}
	
	public boolean isShow() {
		return this.mShow;
	}

	
	private void drawLayout() {
		
		final int TOP_AREA_HEIGHT = 40;

		// BASE LAYOUT
		
		RelativeLayout.LayoutParams params;
		
		params = new RelativeLayout.LayoutParams(mBaseWidth, mBaseHeight);
		params.topMargin  = mAreaMargin.getTop();
		params.leftMargin = mAreaMargin.getLeft();
		RelativeLayout baseLayout = new RelativeLayout(mContext);
		baseLayout.setLayoutParams(params);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		RelativeLayout areaTop = new RelativeLayout(mContext);
		areaTop.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, TOP_AREA_HEIGHT));
		areaTop.setBackgroundColor(Color.TRANSPARENT);
		baseLayout.addView(areaTop);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, mBaseHeight - (TOP_AREA_HEIGHT + mAreaMargin.getTop()));
		params.topMargin = TOP_AREA_HEIGHT;
		LinearLayout areaContent = new LinearLayout(mContext);
		areaContent.setOrientation(LinearLayout.VERTICAL);
		areaContent.setLayoutParams(params);
		areaContent.setBackgroundColor(Color.TRANSPARENT);
		baseLayout.addView(areaContent);

		// HIGHWAY-STATUS & DETAIL-INFO

		LinearLayout areaHighwayStatus;
		RelativeLayout areaDetailInfo;
		
		// HIGHWAY-STATUS

		areaHighwayStatus = new LinearLayout(mContext);
		areaHighwayStatus.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.2f));
		areaHighwayStatus.setBackgroundColor(Color.argb(128,0,0,0));
		areaHighwayStatus.setOrientation(LinearLayout.VERTICAL);
		areaContent.addView(areaHighwayStatus);
		
		// DETAIL-INFO
		
		areaDetailInfo = new RelativeLayout(mContext);
		areaDetailInfo.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.8f));
		areaDetailInfo.setBackgroundColor(Color.argb(128,255,255,255));
		areaContent.addView(areaDetailInfo);
		
		// CLOSE BUTTON
		
		ImageView ivClose = new ImageView(mContext);
		ivClose.setImageResource(R.drawable.icon_close_3);
		ivClose.setOnClickListener(new ThisCloseListener(this));
		
		RelativeLayout imageLayout = new RelativeLayout(mContext);
		imageLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		imageLayout.setGravity(Gravity.RIGHT);
		imageLayout.addView(ivClose);
		areaTop.addView(imageLayout);
		
		// TITLE TEXT VIEW
		
		TextView tvTitle = new TextView(mContext);
		tvTitle.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		tvTitle.setTypeface(BaseData.FONT_FACE);
		tvTitle.setPadding(5, 0, 0, 0);  // L,T,R,B
		tvTitle.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
		tvTitle.setTextColor(Color.WHITE);
		tvTitle.setTextSize(14.0f);
		tvTitle.setText(Html.fromHtml("<b><font color='#ff7f00'>�ͻ����װ�ӵ���(�������)</font> ���� ��</b>"));
		areaTop.addView(tvTitle);
		
		
		
		
		Log.e(TAG, "------------------ highway info size : " + mArrHighwayInfo.size());
		
		// Highway Status

		// ���� �ִ� ���� �ڵ� ����
		// Gallery �� setSelection �޼ҵ带 �̿��ϸ� ��.
		
		int posCR = 0, cntCR = 0;
		int posMJ = 0, cntMJ = 0;
		int posMI = 0, cntMI = 0;

		for (int iIdx = mArrHighwayInfo.size()-1; iIdx >= 0; iIdx--) {
			
			HighwayInfo highwayInfo = mArrHighwayInfo.get(iIdx);
			String sStatus = highwayInfo.getStatus();
			
			if (sStatus.equals(GRADE_CR)) {
				posCR = iIdx;  cntCR++;
			} else if (sStatus.equals(GRADE_MJ)) {
				posMJ = iIdx;  cntMJ++;
			} else if (sStatus.equals(GRADE_MI)) {
				posMI = iIdx;  cntMI++;
			}
			
		}
		
		String sHighwayStatus = "";
		sHighwayStatus += "<b>";
		sHighwayStatus += "<font color='#FF0000'>CR</font> : " + cntCR + "�� , ";
		sHighwayStatus += "<font color='#FFB400'>MJ</font> : " + cntMJ + "�� , ";
		sHighwayStatus += "<font color='#FFF600'>MI</font> : " + cntMI + "��";
		sHighwayStatus += "</b>";
		
		TextView tvHighwayStatus = new TextView(mContext);
		tvHighwayStatus.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.3f));
		tvHighwayStatus.setTypeface(BaseData.FONT_FACE);
		tvHighwayStatus.setGravity(Gravity.CENTER);
		tvHighwayStatus.setTextSize(13.0f);
		tvHighwayStatus.setText(Html.fromHtml(sHighwayStatus));
		
		areaHighwayStatus.addView(tvHighwayStatus);
		
		Gallery highwayList = new Gallery(mContext);
		highwayList.setUnselectedAlpha(0.5f);
		highwayList.setSpacing(-50);
		highwayList.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
		highwayList.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.7f));
		highwayList.setAdapter(new HwListAdapter(mContext));
		highwayList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				Toast.makeText(mContext, mArrHighwayInfo.get(position).getName(), Toast.LENGTH_SHORT).show();
			}
		});
		
		areaHighwayStatus.addView(highwayList);

		if (posCR != 0) {
			highwayList.setSelection(posCR);
		} else if (posMJ != 0) {
			highwayList.setSelection(posMJ);
		} else if (posMI != 0) {
			highwayList.setSelection(posMI);
		}

		// Detail Info
		
		TextView tvTemp = new TextView(mContext);
		tvTemp.setTypeface(BaseData.FONT_FACE);
		tvTemp.setTextSize(13.0f);
		tvTemp.setTextColor(Color.WHITE);
		tvTemp.setText("AAAA");
		areaDetailInfo.addView(tvTemp);
		
		addView(baseLayout);

	}
	
	private class HwListAdapter extends BaseAdapter {
		
		private Context mContext;
		
		private int galleryItemBackground;
		private Hashtable<String,ImagePiece> mHtImagePiece;
		private int posPrev;
		
		public HwListAdapter(Context context) {
			
			this.mContext = context;
			this.mHtImagePiece = new Hashtable<String,ImagePiece>();
			
			posPrev = 0;
			
			TypedArray typedArray = mContext.obtainStyledAttributes(R.styleable.GalleryTheme);
			galleryItemBackground = typedArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
			typedArray.recycle();

		}
		
		@Override
		public int getCount() {
			return mArrHighwayInfo.size();
		}
		
		@Override
		public Object getItem(int position) {
			return position;
		}
		
		@Override
		public long getItemId(int position) {
			
			Log.e(TAG, "------ posPrev : " + posPrev + ", getItemId : " + position);
			
			ImagePiece imagePiece;
			Animation animation;

			try {
				
				animation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in_active_yes);
				animation.setFillAfter(true);
				
				imagePiece = mHtImagePiece.get(Integer.toString(position));
				imagePiece.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
				imagePiece.setAnimation(animation);
				
			} catch (NullPointerException eNull) {
				Log.e(TAG, "------ getItemId : NullPointerException : " + position);
			}

			if (posPrev < position) {

				try {
					
					animation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out_active_no);
					animation.setFillAfter(true);
					
					imagePiece = mHtImagePiece.get(Integer.toString(position-1));
					imagePiece.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
					imagePiece.setAnimation(animation);
					
				} catch (NullPointerException eNull) {
					Log.e(TAG, "------ getItemId : NullPointerException : " + position);
				}

			} else if (posPrev > position) {

				try {
					
					animation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out_active_no);
					animation.setFillAfter(true);
					
					imagePiece = mHtImagePiece.get(Integer.toString(position+1));
					imagePiece.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
					imagePiece.setAnimation(animation);
					
				} catch (NullPointerException eNull) {
					Log.e(TAG, "------ getItemId : NullPointerException : " + position);
				}

			}
			
			posPrev = position;

			return position;
			
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			Log.e(TAG, "------ getView : " + position);
			
			int imageResID;
			String sStatus;
			
			Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in_active_no);
			animation.setFillAfter(true);
			
			HighwayInfo highwayInfo = mArrHighwayInfo.get(position);
			sStatus = highwayInfo.getStatus();

			if (sStatus.equals(GRADE_CR)) {
				imageResID = R.drawable.hw_base_piece_r;
			} else if (sStatus.equals(GRADE_MJ)) {
				imageResID = R.drawable.hw_base_piece_o;
			} else if (sStatus.equals(GRADE_MI)) {
				imageResID = R.drawable.hw_base_piece_y;
			} else {
				imageResID = R.drawable.hw_base_piece_n;
			}

			ImagePiece imagePiece = new ImagePiece(mContext, imageResID, highwayInfo.getName());
			imagePiece.setLayoutParams(new Gallery.LayoutParams(200, 150));
			imagePiece.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
			imagePiece.startAnimation(animation);
			
			mHtImagePiece.put(Integer.toString(position), imagePiece);

			return imagePiece;
			
		}

		private class ImagePiece extends LinearLayout {

			public ImagePiece(Context context, int imageResID, String sTitle) {
				
				super(context);
				
				LinearLayout.LayoutParams params;
				
				params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, 1.0f);
				this.setLayoutParams(params);
				this.setOrientation(LinearLayout.VERTICAL);
				
				params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.8f);
				ImageView imageView = new ImageView(context);
				imageView.setLayoutParams(params);
				imageView.setScaleType(ImageView.ScaleType.CENTER);
				imageView.setImageResource(imageResID);
				this.addView(imageView);
				
				params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.2f);
				TextView textView = new TextView(context);
				textView.setLayoutParams(params);
				textView.setGravity(Gravity.CENTER);
				textView.setTypeface(BaseData.FONT_FACE);
				textView.setTextSize(13.0f);
				textView.setTextColor(Color.WHITE);
				textView.setText(sTitle);
				this.addView(textView);
				
			}
			
		}
		
	}
	
	private class ThisCloseListener implements OnClickListener {
		private MonHwPopupDetail mInstance;
		public ThisCloseListener(MonHwPopupDetail instance) {
			this.mInstance = instance;
		}
		public void onClick(View v) {
			AlphaAnimation aniAlpha = new AlphaAnimation(1.0f, 0.0f);
			aniAlpha.setInterpolator(new AccelerateInterpolator());
			aniAlpha.setDuration(250);
			this.mInstance.startAnimation(aniAlpha);
			this.mInstance.setVisibility(View.GONE);
		}
	}
	
	private void removeLayout() {
		
		this.removeAllViews();
		this.removeAllViewsInLayout();

	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {

		Point pointSrt = new Point();
		Point pointEnd = new Point();
		Paint paint = new Paint();
		RectF rect = null;
		
		final int BASE_MARGIN = 10;
		
		// ��ü ���� ��׶���
		
		paint.reset();
		paint.setColor(Color.BLACK);
		paint.setAlpha((int)(255*0.5));
		paint.setAntiAlias(true);

		pointSrt.x = mAreaMargin.getLeft() - BASE_MARGIN;
		pointSrt.y = mAreaMargin.getTop()  - BASE_MARGIN;
		
		pointEnd.x = mAreaMargin.getLeft() + mBaseWidth  + BASE_MARGIN;
		pointEnd.y = mAreaMargin.getTop()  + mBaseHeight + BASE_MARGIN - 35;
		
		rect = new RectF(pointSrt.x, pointSrt.y, pointEnd.x, pointEnd.y);
		canvas.drawRoundRect(rect, 10.0f, 10.0f, paint);

		AREA_SRT.set(pointSrt.x, pointSrt.y);
		AREA_END.set(pointEnd.x, pointEnd.y);	

		super.dispatchDraw(canvas);
		
	}
	
	@Override
	public void setVisibility(int visibility) {
		
		if (visibility == View.VISIBLE) {
			
			drawLayout();
			mShow = true;
			
		} else if ((visibility == View.INVISIBLE) || (visibility == View.GONE)) {
			
			removeLayout();

			// ��ġ ������ GestureListener �� ��ġ ���۰� ��ø�ǹǷ�,
			// ������ ������ ���� ��ǥ�� �ʱ�ȭ�� �ణ ���� ��Ŵ.
			
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				public void run() {
					getAreaSrt().set(0, 0);
					getAreaEnd().set(0, 0);
					mShow = false;
				}
			}, 1000);

		}
		
		super.setVisibility(visibility);
		
	}

	private class HighwayInfo {
		
		private String code;
		private String name;
		private String status;
		
		public HighwayInfo(String code, String name, String status) {
			this.code = code;
			this.name = name;
			this.status = status;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getName() {
			return name;
		}
		
		public String getStatus() {
			return status;
		}
		
	}
	
}
