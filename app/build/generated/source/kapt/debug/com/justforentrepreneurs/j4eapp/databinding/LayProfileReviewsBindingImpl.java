package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayProfileReviewsBindingImpl extends LayProfileReviewsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(24);
        sIncludes.setIncludes(1, 
            new String[] {"ab_testimonials", "ab_testimonials"},
            new int[] {2, 3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_testimonials,
                com.justforentrepreneurs.j4eapp.R.layout.ab_testimonials});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.liproReview, 4);
        sViewsWithIds.put(R.id.tvEventReviews, 5);
        sViewsWithIds.put(R.id.tvPersonalReviews, 6);
        sViewsWithIds.put(R.id.totalrating, 7);
        sViewsWithIds.put(R.id.totalratingm, 8);
        sViewsWithIds.put(R.id.cpbStrength, 9);
        sViewsWithIds.put(R.id.fivestar, 10);
        sViewsWithIds.put(R.id.fourstar, 11);
        sViewsWithIds.put(R.id.threestar, 12);
        sViewsWithIds.put(R.id.twostar, 13);
        sViewsWithIds.put(R.id.onestar, 14);
        sViewsWithIds.put(R.id.pb5, 15);
        sViewsWithIds.put(R.id.pb4, 16);
        sViewsWithIds.put(R.id.pb3, 17);
        sViewsWithIds.put(R.id.pb2, 18);
        sViewsWithIds.put(R.id.pb1, 19);
        sViewsWithIds.put(R.id.TotalReview, 20);
        sViewsWithIds.put(R.id.WriteReview, 21);
        sViewsWithIds.put(R.id.rvMyReviews, 22);
        sViewsWithIds.put(R.id.liproReview1, 23);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbTestimonialsBinding mboundView11;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbTestimonialsBinding mboundView12;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayProfileReviewsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private LayProfileReviewsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[21]
            , (com.mikhaellopez.circularprogressbar.CircularProgressBar) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.TextView) bindings[14]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[19]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[18]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[17]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[16]
            , (com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[13]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbTestimonialsBinding) bindings[2];
        setContainedBinding(this.mboundView11);
        this.mboundView12 = (com.justforentrepreneurs.j4eapp.databinding.AbTestimonialsBinding) bindings[3];
        setContainedBinding(this.mboundView12);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView11.invalidateAll();
        mboundView12.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        if (mboundView12.hasPendingBindings()) {
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
        mboundView11.setLifecycleOwner(lifecycleOwner);
        mboundView12.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView11);
        executeBindingsOn(mboundView12);
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