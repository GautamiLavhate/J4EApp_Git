package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AbEventslayoutBindingImpl extends AbEventslayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.eventDetailsRelLay, 1);
        sViewsWithIds.put(R.id.eventDetailsRelLay23, 2);
        sViewsWithIds.put(R.id.ivImg, 3);
        sViewsWithIds.put(R.id.llContain, 4);
        sViewsWithIds.put(R.id.eventtitle, 5);
        sViewsWithIds.put(R.id.datetime, 6);
        sViewsWithIds.put(R.id.address, 7);
        sViewsWithIds.put(R.id.amount, 8);
        sViewsWithIds.put(R.id.map, 9);
        sViewsWithIds.put(R.id.orgnaizenumber, 10);
        sViewsWithIds.put(R.id.msgc, 11);
        sViewsWithIds.put(R.id.tikitbooking, 12);
        sViewsWithIds.put(R.id.ivshare, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AbEventslayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private AbEventslayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[12]
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