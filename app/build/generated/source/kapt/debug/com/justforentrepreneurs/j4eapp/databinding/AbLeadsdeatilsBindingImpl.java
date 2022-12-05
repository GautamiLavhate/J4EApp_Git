package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AbLeadsdeatilsBindingImpl extends AbLeadsdeatilsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.leaddeatis, 1);
        sViewsWithIds.put(R.id.imagereqiurment, 2);
        sViewsWithIds.put(R.id.companyName, 3);
        sViewsWithIds.put(R.id.address, 4);
        sViewsWithIds.put(R.id.date, 5);
        sViewsWithIds.put(R.id.title, 6);
        sViewsWithIds.put(R.id.description, 7);
        sViewsWithIds.put(R.id.lead_post_by, 8);
        sViewsWithIds.put(R.id.llProfileInfo, 9);
        sViewsWithIds.put(R.id.ivProfileImg, 10);
        sViewsWithIds.put(R.id.fullname, 11);
        sViewsWithIds.put(R.id.companyName1, 12);
        sViewsWithIds.put(R.id.address1, 13);
        sViewsWithIds.put(R.id.moreIV, 14);
        sViewsWithIds.put(R.id.msg, 15);
        sViewsWithIds.put(R.id.tvRecommended, 16);
        sViewsWithIds.put(R.id.tvRecommendedMySelf, 17);
        sViewsWithIds.put(R.id.llRecommendedSection, 18);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AbLeadsdeatilsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private AbLeadsdeatilsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[2]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[10]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[18]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
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