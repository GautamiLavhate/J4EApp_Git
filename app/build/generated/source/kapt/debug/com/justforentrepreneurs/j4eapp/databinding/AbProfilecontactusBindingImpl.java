package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AbProfilecontactusBindingImpl extends AbProfilecontactusBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llProfileInfo, 1);
        sViewsWithIds.put(R.id.ivProfileImg, 2);
        sViewsWithIds.put(R.id.userName, 3);
        sViewsWithIds.put(R.id.companyName, 4);
        sViewsWithIds.put(R.id.address, 5);
        sViewsWithIds.put(R.id.messageLL, 6);
        sViewsWithIds.put(R.id.messageimg, 7);
        sViewsWithIds.put(R.id.llFollow, 8);
        sViewsWithIds.put(R.id.llFollowst, 9);
        sViewsWithIds.put(R.id.ivStatusFollowing, 10);
        sViewsWithIds.put(R.id.llShare, 11);
        sViewsWithIds.put(R.id.llQrCode, 12);
        sViewsWithIds.put(R.id.llRewardPoint, 13);
        sViewsWithIds.put(R.id.rewardpoint, 14);
        sViewsWithIds.put(R.id.llRanks, 15);
        sViewsWithIds.put(R.id.rank, 16);
        sViewsWithIds.put(R.id.connections, 17);
        sViewsWithIds.put(R.id.baatch, 18);
        sViewsWithIds.put(R.id.tabProfile, 19);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AbProfilecontactusBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private AbProfilecontactusBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[17]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[3]
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