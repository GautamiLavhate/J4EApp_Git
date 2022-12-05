package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.justforentrepreneurs.j4eapp.DataBinderMapperImpl());
  }
}
