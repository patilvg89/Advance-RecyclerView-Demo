# RecyclerviewEmptyViewSupport
Developer can use Empty TextView or ImageView while data list is Zero in the RecyclerViewAdapter
 
1) a) Use below link to download  .aar file, add this library to libs folder and import to project
     link: https://github.com/patilvg89/RecyclerviewEmptyViewSupport/blob/master/recyclerview-release.aar
 
 
  b) Copy below code to project level build.gradle
 
      allprojects {
          repositories {
              jcenter()
              flatDir {
                  dirs 'libs'
              }
          }
       }
 
 
  c) Include library dependency in app level build.gradle as below
   compile(name:'recyclerview-release', ext:'aar')
 
 
 
2) Add below layout to your xml
 
 
   <com.virendra.view.RecyclerViewEmptySupport
       android:id="@+id/recyclerview1"
       android:layout_width="match_parent"
       android:layout_height="match_parent" />
 
3) Create Adapter and set Adapter to recyclerview1
 
4) Use setAdapter() method as per your requirement
   e.g. a)  recyclerview1.setAdapter(adapter);
        b)  recyclerview1.setAdapterWithEmptyTextView(adapter, "There are no record to show...");
        c)  recyclerview1.setAdapterWithEmptyImageView(adapter, ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        d)  recyclerview1.setAdapterWithEmptyImageView(adapter, ContextCompat.getDrawable(this, R.mipmap.ic_launcher), 100, 100); // unit is dp
        e)  recyclerview1.setAdapterWithEmptyImageView(adapter, null); //To show library default image
 
5) Empty Text and Image can be added in xml layout
   If your mentioned text and image in xml layout then ImageView has more priority than TextView
   a)  For empty text:  import at parent layout:  xmlns:app="http://schemas.android.com/apk/res-auto"
 
       <com.virendra.view.RecyclerViewEmptySupport
           android:id="@+id/recyclerview1"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           app:empty_list_text="No data found..." />
 
    b) For image : import at parent layout:  xmlns:app="http://schemas.android.com/apk/res-auto"
       If height and width not mentioned then image parameters are WRAP_CONTENT
 
       <com.virendra.view.RecyclerViewEmptySupport
            android:id="@+id/recyclerview1"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:empty_image_drawable="@mipmap/ic_launcher"
            app:empty_image_height="100dp"
            app:empty_image_width="100dp" />
 
 
 6) Recyclerview Pagination (Currently set Empty image/text not supported)
     int visibleThreshold = 10; // visible items
     int totalItemCount = 101;//value from  server response where server returns the total count for list
     recyclerviewSupport.setPaginationAdapter(adapter1, visibleThreshold, totalItemCount, new RecyclerViewCallback() {
     @Override
     public void loadMoreItems(int pageNo) {
         //do API call and get response
         API_CALL(pageNo);
         
         //add response to list
         list.addAll(...);
         
         //update adapter
         recyclerviewSupport.updatePaginationAdapter(adapter1, list.size());
     }

     @Override
     public void hasLoadedAllItems(boolean value) {
         Log.d("TAG", "Reached to end");
     }
 });
 
