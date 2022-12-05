package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AbEventdetailsBindingImpl extends AbEventdetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 1);
        sViewsWithIds.put(R.id.eventImage, 2);
        sViewsWithIds.put(R.id.eventtitle, 3);
        sViewsWithIds.put(R.id.catname, 4);
        sViewsWithIds.put(R.id.tvStatus, 5);
        sViewsWithIds.put(R.id.memberfree, 6);
        sViewsWithIds.put(R.id.GuestFees, 7);
        sViewsWithIds.put(R.id.eventsdate, 8);
        sViewsWithIds.put(R.id.phonenumber, 9);
        sViewsWithIds.put(R.id.address, 10);
        sViewsWithIds.put(R.id.description, 11);
        sViewsWithIds.put(R.id.othersmore, 12);
        sViewsWithIds.put(R.id.collapse, 13);
        sViewsWithIds.put(R.id.invitedPeopleli, 14);
        sViewsWithIds.put(R.id.invitedPeople, 15);
        sViewsWithIds.put(R.id.ivProfileImg1d, 16);
        sViewsWithIds.put(R.id.ivProfileImg2d, 17);
        sViewsWithIds.put(R.id.ivProfileImg2, 18);
        sViewsWithIds.put(R.id.ivProfileImg21, 19);
        sViewsWithIds.put(R.id.ivProfileImg211, 20);
        sViewsWithIds.put(R.id.tvInvite, 21);
        sViewsWithIds.put(R.id.Gallerycard, 22);
        sViewsWithIds.put(R.id.llMain, 23);
        sViewsWithIds.put(R.id.Galleryimg, 24);
        sViewsWithIds.put(R.id.llEventProfileDetail, 25);
        sViewsWithIds.put(R.id.Eventbyimg, 26);
        sViewsWithIds.put(R.id.nameEventby, 27);
        sViewsWithIds.put(R.id.revirecard, 28);
        sViewsWithIds.put(R.id.totalrating, 29);
        sViewsWithIds.put(R.id.TotalReviewmain, 30);
        sViewsWithIds.put(R.id.fivestar, 31);
        sViewsWithIds.put(R.id.fourstar, 32);
        sViewsWithIds.put(R.id.threestar, 33);
        sViewsWithIds.put(R.id.twostar, 34);
        sViewsWithIds.put(R.id.onestar, 35);
        sViewsWithIds.put(R.id.pb5, 36);
        sViewsWithIds.put(R.id.pb4, 37);
        sViewsWithIds.put(R.id.pb3, 38);
        sViewsWithIds.put(R.id.pb2, 39);
        sViewsWithIds.put(R.id.pb1, 40);
        sViewsWithIds.put(R.id.tvEventReviews, 41);
        sViewsWithIds.put(R.id.totalrating1, 42);
        sViewsWithIds.put(R.id.reviewLi, 43);
        sViewsWithIds.put(R.id.ivReviewProfileImg, 44);
        sViewsWithIds.put(R.id.ivName, 45);
        sViewsWithIds.put(R.id.tvDate, 46);
        sViewsWithIds.put(R.id.rating, 47);
        sViewsWithIds.put(R.id.note, 48);
        sViewsWithIds.put(R.id.seeallrevirews, 49);
        sViewsWithIds.put(R.id.orgnaizename, 50);
        sViewsWithIds.put(R.id.Adresss, 51);
        sViewsWithIds.put(R.id.ShortDesp, 52);
        sViewsWithIds.put(R.id.llLoginLinkedInimg, 53);
        sViewsWithIds.put(R.id.facebookimg, 54);
        sViewsWithIds.put(R.id.twitter, 55);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AbEventdetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 56, sIncludes, sViewsWithIds));
    }
    private AbEventdetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[51]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[26]
            , (androidx.cardview.widget.CardView) bindings[22]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[24]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[52]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[54]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[15]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.TextView) bindings[45]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[16]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[18]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[19]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[20]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[17]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[44]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.ImageView) bindings[53]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[50]
            , (android.widget.TextView) bindings[12]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[40]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[39]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[38]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[37]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[36]
            , (android.widget.TextView) bindings[9]
            , (android.widget.RatingBar) bindings[47]
            , (android.widget.LinearLayout) bindings[43]
            , (androidx.cardview.widget.CardView) bindings[28]
            , (android.widget.TextView) bindings[49]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[42]
            , (android.widget.TextView) bindings[46]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[55]
            , (android.widget.TextView) bindings[34]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}