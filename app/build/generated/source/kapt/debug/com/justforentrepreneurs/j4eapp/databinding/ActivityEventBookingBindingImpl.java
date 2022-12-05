package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEventBookingBindingImpl extends ActivityEventBookingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(15);
        sIncludes.setIncludes(1, 
            new String[] {"ab_event_booking"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_event_booking});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 3);
        sViewsWithIds.put(R.id.eventImage, 4);
        sViewsWithIds.put(R.id.ivBack, 5);
        sViewsWithIds.put(R.id.ivProfileImg, 6);
        sViewsWithIds.put(R.id.eventtitle, 7);
        sViewsWithIds.put(R.id.eventStartdate, 8);
        sViewsWithIds.put(R.id.userName, 9);
        sViewsWithIds.put(R.id.eveventemail, 10);
        sViewsWithIds.put(R.id.eventcategory, 11);
        sViewsWithIds.put(R.id.phonenumber, 12);
        sViewsWithIds.put(R.id.fesstotal, 13);
        sViewsWithIds.put(R.id.tvContinueBooking, 14);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbEventBookingBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEventBookingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityEventBookingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.LinearLayout) bindings[5]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[9]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbEventBookingBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView1);
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