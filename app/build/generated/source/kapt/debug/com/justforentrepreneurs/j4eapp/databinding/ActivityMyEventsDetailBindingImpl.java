package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyEventsDetailBindingImpl extends ActivityMyEventsDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(71);
        sIncludes.setIncludes(0, 
            new String[] {"lay_toolbar_events"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_events});
        sIncludes.setIncludes(1, 
            new String[] {"ab_eventdetails"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_eventdetails});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 4);
        sViewsWithIds.put(R.id.eventImage, 5);
        sViewsWithIds.put(R.id.eventtitle, 6);
        sViewsWithIds.put(R.id.catname, 7);
        sViewsWithIds.put(R.id.tvStatus, 8);
        sViewsWithIds.put(R.id.memberfree, 9);
        sViewsWithIds.put(R.id.GuestFees, 10);
        sViewsWithIds.put(R.id.eventsdate, 11);
        sViewsWithIds.put(R.id.phonenumber, 12);
        sViewsWithIds.put(R.id.address, 13);
        sViewsWithIds.put(R.id.description, 14);
        sViewsWithIds.put(R.id.othersmore, 15);
        sViewsWithIds.put(R.id.collapse, 16);
        sViewsWithIds.put(R.id.invitedPeopleli, 17);
        sViewsWithIds.put(R.id.invitedPeople, 18);
        sViewsWithIds.put(R.id.ivProfileImg1d, 19);
        sViewsWithIds.put(R.id.ivProfileImg2d, 20);
        sViewsWithIds.put(R.id.ivProfileImg2, 21);
        sViewsWithIds.put(R.id.ivProfileImg21, 22);
        sViewsWithIds.put(R.id.ivProfileImg211, 23);
        sViewsWithIds.put(R.id.tvInvite, 24);
        sViewsWithIds.put(R.id.Gallerycard, 25);
        sViewsWithIds.put(R.id.rvGallery, 26);
        sViewsWithIds.put(R.id.llEventProfileDetail, 27);
        sViewsWithIds.put(R.id.Eventbyimg, 28);
        sViewsWithIds.put(R.id.nameEventby, 29);
        sViewsWithIds.put(R.id.seemoreEventprofile, 30);
        sViewsWithIds.put(R.id.revirecard, 31);
        sViewsWithIds.put(R.id.totalrating, 32);
        sViewsWithIds.put(R.id.TotalReviewmain, 33);
        sViewsWithIds.put(R.id.fivestar, 34);
        sViewsWithIds.put(R.id.fourstar, 35);
        sViewsWithIds.put(R.id.threestar, 36);
        sViewsWithIds.put(R.id.twostar, 37);
        sViewsWithIds.put(R.id.onestar, 38);
        sViewsWithIds.put(R.id.pb5, 39);
        sViewsWithIds.put(R.id.pb4, 40);
        sViewsWithIds.put(R.id.pb3, 41);
        sViewsWithIds.put(R.id.pb2, 42);
        sViewsWithIds.put(R.id.pb1, 43);
        sViewsWithIds.put(R.id.tvEventReviews, 44);
        sViewsWithIds.put(R.id.totalrating1, 45);
        sViewsWithIds.put(R.id.reviewLi, 46);
        sViewsWithIds.put(R.id.ivReviewProfileImg, 47);
        sViewsWithIds.put(R.id.ivName, 48);
        sViewsWithIds.put(R.id.tvDate, 49);
        sViewsWithIds.put(R.id.rating, 50);
        sViewsWithIds.put(R.id.note, 51);
        sViewsWithIds.put(R.id.seeallrevirews, 52);
        sViewsWithIds.put(R.id.orgnaizename, 53);
        sViewsWithIds.put(R.id.Adresss, 54);
        sViewsWithIds.put(R.id.ShortDesp, 55);
        sViewsWithIds.put(R.id.llLoginLinkedInimg, 56);
        sViewsWithIds.put(R.id.facebookimg, 57);
        sViewsWithIds.put(R.id.twitter, 58);
        sViewsWithIds.put(R.id.tvBookTicket, 59);
        sViewsWithIds.put(R.id.btdPublishev, 60);
        sViewsWithIds.put(R.id.llBottomContent, 61);
        sViewsWithIds.put(R.id.interestedLi, 62);
        sViewsWithIds.put(R.id.ivInterested, 63);
        sViewsWithIds.put(R.id.tvInterestedCount, 64);
        sViewsWithIds.put(R.id.tvattaendTicket, 65);
        sViewsWithIds.put(R.id.ivAttending, 66);
        sViewsWithIds.put(R.id.tvAttendingCount, 67);
        sViewsWithIds.put(R.id.MaybeLi, 68);
        sViewsWithIds.put(R.id.ivMaybe, 69);
        sViewsWithIds.put(R.id.tvMaybe, 70);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbEventdetailsBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyEventsDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 71, sIncludes, sViewsWithIds));
    }
    private ActivityMyEventsDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[54]
            , (android.widget.ImageView) bindings[28]
            , (androidx.cardview.widget.CardView) bindings[25]
            , (android.widget.TextView) bindings[10]
            , (android.widget.LinearLayout) bindings[68]
            , (android.widget.TextView) bindings[55]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[13]
            , (android.widget.Button) bindings[60]
            , (android.widget.TextView) bindings[7]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[6]
            , (android.widget.ImageView) bindings[57]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[35]
            , (android.widget.LinearLayout) bindings[62]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.ImageView) bindings[66]
            , (android.widget.ImageView) bindings[63]
            , (android.widget.ImageView) bindings[69]
            , (android.widget.TextView) bindings[48]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[19]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[21]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[22]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[23]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[20]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[47]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[61]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.ImageView) bindings[56]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[53]
            , (android.widget.TextView) bindings[15]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[43]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[42]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[41]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[40]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[39]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RatingBar) bindings[50]
            , (android.widget.LinearLayout) bindings[46]
            , (androidx.cardview.widget.CardView) bindings[31]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (android.widget.TextView) bindings[52]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[36]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEventsBinding) bindings[2]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[67]
            , (android.widget.TextView) bindings[59]
            , (android.widget.TextView) bindings[49]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[64]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[70]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[65]
            , (android.widget.ImageView) bindings[58]
            , (android.widget.TextView) bindings[37]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbEventdetailsBinding) bindings[3];
        setContainedBinding(this.mboundView1);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        toolbar.invalidateAll();
        mboundView1.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        if (mboundView1.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbar.setLifecycleOwner(lifecycleOwner);
        mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarEventsBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarEventsBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(toolbar);
        executeBindingsOn(mboundView1);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}