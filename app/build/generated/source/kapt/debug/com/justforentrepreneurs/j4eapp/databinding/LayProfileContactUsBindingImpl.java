package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayProfileContactUsBindingImpl extends LayProfileContactUsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linercontactus, 1);
        sViewsWithIds.put(R.id.fullname1, 2);
        sViewsWithIds.put(R.id.gendersp, 3);
        sViewsWithIds.put(R.id.email, 4);
        sViewsWithIds.put(R.id.callcontcts, 5);
        sViewsWithIds.put(R.id.txtWhatsapp, 6);
        sViewsWithIds.put(R.id.txtWhatsappBusiness, 7);
        sViewsWithIds.put(R.id.companyName, 8);
        sViewsWithIds.put(R.id.Designationid, 9);
        sViewsWithIds.put(R.id.totolyearexperice, 10);
        sViewsWithIds.put(R.id.businessCategory, 11);
        sViewsWithIds.put(R.id.companywebside, 12);
        sViewsWithIds.put(R.id.companyAddress, 13);
        sViewsWithIds.put(R.id.datec, 14);
        sViewsWithIds.put(R.id.businesstv, 15);
        sViewsWithIds.put(R.id.forntviewrv, 16);
        sViewsWithIds.put(R.id.related_detailsindicator, 17);
        sViewsWithIds.put(R.id.googleimg, 18);
        sViewsWithIds.put(R.id.facebookimg, 19);
        sViewsWithIds.put(R.id.llLoginLinkedInimg, 20);
        sViewsWithIds.put(R.id.linercontactus1, 21);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayProfileContactUsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private LayProfileContactUsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[19]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.ImageView) bindings[20]
            , (me.relex.circleindicator.CircleIndicator2) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
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