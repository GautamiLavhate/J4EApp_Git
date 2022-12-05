package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AdapterAllPostsBindingImpl extends AdapterAllPostsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayoutPost, 1);
        sViewsWithIds.put(R.id.ivProfileImg, 2);
        sViewsWithIds.put(R.id.linearlayoutProfileDetail, 3);
        sViewsWithIds.put(R.id.fullname, 4);
        sViewsWithIds.put(R.id.datetime, 5);
        sViewsWithIds.put(R.id.ivEditPost, 6);
        sViewsWithIds.put(R.id.cateimage, 7);
        sViewsWithIds.put(R.id.description, 8);
        sViewsWithIds.put(R.id.othersmore, 9);
        sViewsWithIds.put(R.id.collapse, 10);
        sViewsWithIds.put(R.id.postimg, 11);
        sViewsWithIds.put(R.id.llComments, 12);
        sViewsWithIds.put(R.id.posttotalcomment, 13);
        sViewsWithIds.put(R.id.llLike, 14);
        sViewsWithIds.put(R.id.imagelike, 15);
        sViewsWithIds.put(R.id.totalike, 16);
        sViewsWithIds.put(R.id.llShare, 17);
        sViewsWithIds.put(R.id.linearlayoutBuddyMeet, 18);
        sViewsWithIds.put(R.id.linearlayoutProfileDetailBuddyMeet, 19);
        sViewsWithIds.put(R.id.dateshort, 20);
        sViewsWithIds.put(R.id.weak, 21);
        sViewsWithIds.put(R.id.linearlayoutBonClick, 22);
        sViewsWithIds.put(R.id.ivProfileImgBM, 23);
        sViewsWithIds.put(R.id.name, 24);
        sViewsWithIds.put(R.id.ivProfileImgBM2, 25);
        sViewsWithIds.put(R.id.name2, 26);
        sViewsWithIds.put(R.id.time, 27);
        sViewsWithIds.put(R.id.llLocation, 28);
        sViewsWithIds.put(R.id.tcLocation, 29);
        sViewsWithIds.put(R.id.tvDescription, 30);
        sViewsWithIds.put(R.id.othersmoreBM, 31);
        sViewsWithIds.put(R.id.collapseBM, 32);
        sViewsWithIds.put(R.id.llCommentsBuddyMeet, 33);
        sViewsWithIds.put(R.id.posttotalcommentBuddyMeet, 34);
        sViewsWithIds.put(R.id.llLikeBuddyMeet, 35);
        sViewsWithIds.put(R.id.imagelikeBuddyMeet, 36);
        sViewsWithIds.put(R.id.totalikeBuddyMeet, 37);
        sViewsWithIds.put(R.id.llShareBuddyMeet, 38);
        sViewsWithIds.put(R.id.linearlayoutRequirement, 39);
        sViewsWithIds.put(R.id.ivProfileImgReq, 40);
        sViewsWithIds.put(R.id.title, 41);
        sViewsWithIds.put(R.id.dobet, 42);
        sViewsWithIds.put(R.id.txtRequirement, 43);
        sViewsWithIds.put(R.id.ivShare, 44);
        sViewsWithIds.put(R.id.descriptionReq, 45);
        sViewsWithIds.put(R.id.othersmoreReq, 46);
        sViewsWithIds.put(R.id.collapseReq, 47);
        sViewsWithIds.put(R.id.requirementimg, 48);
        sViewsWithIds.put(R.id.llCommentsRequirement, 49);
        sViewsWithIds.put(R.id.posttotalcommentRequirement, 50);
        sViewsWithIds.put(R.id.llLikeRequirement, 51);
        sViewsWithIds.put(R.id.imagelikeRequirement, 52);
        sViewsWithIds.put(R.id.totalikeRequirement, 53);
        sViewsWithIds.put(R.id.llShareRequirement, 54);
        sViewsWithIds.put(R.id.linearlayoutEvent, 55);
        sViewsWithIds.put(R.id.eventDetailsRelLay, 56);
        sViewsWithIds.put(R.id.ivImg, 57);
        sViewsWithIds.put(R.id.llContain, 58);
        sViewsWithIds.put(R.id.eventtitle, 59);
        sViewsWithIds.put(R.id.datetimeEvent, 60);
        sViewsWithIds.put(R.id.address, 61);
        sViewsWithIds.put(R.id.amount, 62);
        sViewsWithIds.put(R.id.llCommentsEvent, 63);
        sViewsWithIds.put(R.id.posttotalcommentEvent, 64);
        sViewsWithIds.put(R.id.llLikeEvent, 65);
        sViewsWithIds.put(R.id.imagelikeEvent, 66);
        sViewsWithIds.put(R.id.totalikeEvent, 67);
        sViewsWithIds.put(R.id.llShareEvent, 68);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AdapterAllPostsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 69, sIncludes, sViewsWithIds));
    }
    private AdapterAllPostsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[61]
            , (android.widget.TextView) bindings[62]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[60]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[42]
            , (android.widget.RelativeLayout) bindings[56]
            , (android.widget.TextView) bindings[59]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[66]
            , (android.widget.ImageView) bindings[52]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[57]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[23]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[25]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[40]
            , (android.widget.ImageView) bindings[44]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[55]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[39]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[33]
            , (android.widget.LinearLayout) bindings[63]
            , (android.widget.LinearLayout) bindings[49]
            , (android.widget.LinearLayout) bindings[58]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[35]
            , (android.widget.LinearLayout) bindings[65]
            , (android.widget.LinearLayout) bindings[51]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[38]
            , (android.widget.LinearLayout) bindings[68]
            , (android.widget.LinearLayout) bindings[54]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[46]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[64]
            , (android.widget.TextView) bindings[50]
            , (android.widget.ImageView) bindings[48]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[67]
            , (android.widget.TextView) bindings[53]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[21]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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