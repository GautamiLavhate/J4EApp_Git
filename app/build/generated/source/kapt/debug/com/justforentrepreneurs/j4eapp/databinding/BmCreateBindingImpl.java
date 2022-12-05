package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BmCreateBindingImpl extends BmCreateBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.memberdetails, 1);
        sViewsWithIds.put(R.id.linearlayoutMenu1, 2);
        sViewsWithIds.put(R.id.linearlayoutCreateReq, 3);
        sViewsWithIds.put(R.id.linearlayoutCreateEvent, 4);
        sViewsWithIds.put(R.id.linearlayoutCreatePost, 5);
        sViewsWithIds.put(R.id.linearlayoutCreateDeal, 6);
        sViewsWithIds.put(R.id.linearlayoutCreateBuddyMeet, 7);
        sViewsWithIds.put(R.id.linearlayoutCreateOfflineBusiness, 8);
        sViewsWithIds.put(R.id.linearlayoutCreateReferral, 9);
        sViewsWithIds.put(R.id.linearlayoutMenu2, 10);
        sViewsWithIds.put(R.id.linearlayoutCreateReq1, 11);
        sViewsWithIds.put(R.id.linearlayoutCreatePost1, 12);
        sViewsWithIds.put(R.id.linearlayoutCreateDeal1, 13);
        sViewsWithIds.put(R.id.linearlayoutCreateBuddyMeet1, 14);
        sViewsWithIds.put(R.id.linearlayoutCreateOfflineBusiness1, 15);
        sViewsWithIds.put(R.id.linearlayoutCreateReferral1, 16);
        sViewsWithIds.put(R.id.ivcancle, 17);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BmCreateBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private BmCreateBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[17]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[1]
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