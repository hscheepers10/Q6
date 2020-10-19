//////////package com.example.satourismapp;
//////////
//////////import android.content.Context;
//////////import android.database.Cursor;
//////////import android.database.sqlite.SQLiteDatabase;
//////////import android.database.sqlite.SQLiteOpenHelper;
//////////
////////////public class BankUserDetails {
////////////    //declaring variables
////////////    public String ID;
////////////    public String FirstName;
////////////    public String LastName;
////////////    public String Email;public String Password;
////////////    public String Mobile;public String Gender;
////////////    public String currentaccount;
////////////    public String savingsaccount;
////////////
////////////    //Constructor with all parameters
////////////    public BankUserDetails(String Id, String fname, String lname,String email,String password, String mobile, String gender, String current, String savings) {
////////////        this.ID = Id;
////////////        this.FirstName = fname;
////////////        this.LastName = lname;
////////////        this.Email = email;
////////////        this.Password = password;
////////////        this.Mobile = mobile;
////////////        this.Gender = gender;
////////////        this.currentaccount = current;
////////////        this.savingsaccount = savings;}
////////////
////////////        //getters
////////////        public String getID(){
////////////            return ID;
////////////        }
////////////
////////////        public String getFirstName(){
////////////            return FirstName;
////////////        }
////////////
////////////        public String getLastName(){
////////////            return LastName;
////////////        }
////////////
////////////        public String getEmail(){
////////////            return Email;
////////////        }
////////////
////////////        public String getMobile(){
////////////            return Mobile;
////////////        }
////////////
////////////        public String getGender(){
////////////            return Gender;
////////////        }
////////////
////////////        public String getCurrentaccount(){
////////////            return currentaccount;
////////////        }
////////////
////////////        public String getSavingsaccount() {
////////////            return savingsaccount;}
////////////        }
//////////
//////////public class SqliteHelper extends SQLiteOpenHelper {
//////////    //DATABASE NAME
//////////    public static final String DATABASE_NAME = "sisonkebank";
//////////    public static final int DATABASE_VERSION = 1;
//////////    public static final String TABLE_USERS = "users";
//////////    public static final String KEY_ID = "id";
//////////    public static final String KEY_FIRSTNAME= "firstname";
//////////    public static final String KEY_LASTNAME= "lastname";
//////////    public static final String KEY_EMAIL = "email";
//////////    public static final String KEY_PASSWORD = "password";
//////////    public static final String KEY_MOBILE = "mobile";
//////////    public static final String KEY_GENDER = "gender";
//////////    public static final String KEY_CURRENT= "current";
//////////    public static final String KEY_SAVINGS= "savings";
//////////
//////////    //SQL for creating users table
//////////    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS +
//////////            " ( " + KEY_ID + " INTEGER PRIMARY KEY, " +
//////////            KEY_FIRSTNAME + " TEXT, " +
//////////            KEY_LASTNAME + " TEXT, " +
//////////            KEY_EMAIL + " TEXT, " +
//////////            KEY_PASSWORD + " TEXT, " +
//////////            KEY_MOBILE + " TEXT, " +
//////////            KEY_GENDER + " TEXT, " +
//////////            KEY_CURRENT + " TEXT, " +
//////////            KEY_SAVINGS + " TEXT " + " ) ";
//////////
//////////    public SqliteHelper(Context context) {
//////////        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//////////    }
//////////
//////////    @Override
//////////    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//////////    sqLiteDatabase.execSQL(SQL_TABLE_USERS
//////////    }
//////////
//////////    @Override
//////////    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//////////
//////////        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
//////////    }
//////////
//////////    //using this method we can add users to user table
//////////    public void addUser(BankUserDetails user) {
//////////        //get writable database
//////////        SQLiteDatabase db = this.getWritableDatabase();
//////////        //create content values to insert
//////////        ContentValues values = new ContentValues();
//////////        //Put firstname in @values
//////////        values.put(KEY_FIRSTNAME, user.FirstName);
//////////        //Put lastname in @values
//////////        values.put(KEY_LASTNAME, user.LastName);
//////////        //Put email in @values
//////////        values.put(KEY_EMAIL, user.Email);
//////////        //Put password in @values
//////////        values.put(KEY_PASSWORD, user.Password);
//////////        //Put mobile in @values
//////////        values.put(KEY_MOBILE, user.Mobile);
//////////        //Put gender in @values
//////////        values.put(KEY_GENDER, user.Gender);
//////////        //Put current in @values
//////////        values.put(KEY_CURRENT, user.currentaccount);
//////////        //Put savings in @values
//////////        values.put(KEY_SAVINGS, user.savingsaccount);
//////////        // insert row
//////////        long todo_id = db.insert(TABLE_USERS, null, values);
//////////    }
//////////
//////////    //using this method we can update the balance of the current or savings account
//////////    public void updateBalance (BankUserDetails user){
//////////        //get writable database
//////////        SQLiteDatabase db = this.getWritableDatabase();
//////////        //create content values to insert
//////////        ContentValues values = new ContentValues();
//////////        values.put(KEY_CURRENT, user.currentaccount);
//////////        //Put savings in @values
//////////        values.put(KEY_SAVINGS, user.savingsaccount);
//////////        String whereClause = KEY_EMAIL + "=?";String whereArgs[] = {user.Email};
//////////        // update row
//////////        long todo_id = db.update(TABLE_USERS, values, whereClause,whereArgs);
//////////    }
//////////    public BankUserDetails Authenticate(BankUserDetails user) {
//////////        SQLiteDatabase db = this.getReadableDatabase();
//////////        Cursor cursor = db.query(TABLE_USERS,
//////////                // Selecting Table
//////////                new String[]{KEY_ID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_EMAIL,KEY_PASSWORD, KEY_MOBILE, KEY_GENDER, KEY_CURRENT,
//////////                KEY_SAVINGS},
//////////                //Selecting columns want to
//////////                query KEY_EMAIL + "=?", new String[]{user.Email}, Where clause null, null, null);
//////////        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
//////////            //if cursor has value then in user database there is user associated with this given email
//////////            BankUserDetails user1 = new BankUserDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8)) ;
//////////            //Match both passwords check they are same or not
//////////            if (user.Password.equalsIgnoreCase(user1.Password)) {
//////////                return user1;
//////////                //return cursor.getString(9);
//////////                }
//////////        }
//////////        //if user password does not matches or there is no record with that email then
//////////        return @false return null;
//////////    }
//////////
//////////
//////////
//////////    public BankUserDetails getUserDetails (BankUserDetails user) {
//////////        SQLiteDatabase db = this.getReadableDatabase();
//////////            Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID, KEY_FIRSTNAME, KEY_LASTNAME}, KEY_EMAIL + "=?",
//////////                    new String[]{user.Email}, null, null, null);
//////////
//////////            if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
//////////                //if cursor has value then in user database there is user associated with this given email
//////////                BankUserDetails user1 = new BankUserDetails(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
//////////                return user1;
//////////            }
//////////            //case where user is not found
//////////        return null;
//////////    }
//////////    //method to check if email existspublic
//////////    booleanisEmailExists(String email){
//////////        SQLiteDatabase db = this.getReadableDatabase();Cursor cursor = db.query(TABLE_USERS,
//////////                // Selecting Table
//////////                new String[]{KEY_ID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_EMAIL,KEY_PASSWORD, KEY_MOBILE, KEY_GENDER},
//////////                //Selecting columns want to
//////////                query KEY_EMAIL + "=?", new String[]{email},
//////////                //Where clause
//////////            null, null, null);
//////////        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
//////////            //if cursorhas value then in user database there is user associated with this given email so return true
//////////            return true;
//////////        }
//////////        //if email does not exist return false
//////////        return false;
//////////    }
//////////    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//////////        super(context, name, factory, version);
//////////    }
//////////
//////////    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int
//////////            }
//////////            }
//////////        version, @Nullable DatabaseErrorHandler errorHandler) {
//////////        super(context, name, factory, version, errorHandler);
//////////    }
//////////
//////////    @RequiresApi(api = Build.VERSION_CODES.P)
//////////    public SqliteHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//////////        super(context, name,version, openParams); } }
//////////
////////
////////
////////
////////
////get email from main activity
//Bundle bundle = getIntent().getExtras();
//final String email = bundle.getString("email");
////intilialise widgets
//transfer = (findViewById(R.id.btntransferfunds));
//current = (findViewById(R.id.txttranscurrent));
//savings = (findViewById(R.id.txttranssavings));
//transferamount = (findViewById(R.id.edttransamount));
//transferoption = (findViewById(R.id.transspinner));
////intialising sqlitehelper
//sqliteHelper = new SqliteHelper(this);
////get details of current user from database
//BankUserDetails currentUser = sqliteHelper.getUserDetails(new BankUserDetails(null, null, null, email, null, null, null, null, null));
//if (currentUser != null) {
//    current.setText(currentUser.getCurrentaccount());
//    savings.setText(currentUser.getSavingsaccount());
//    //get value of current and savings account
//        currentbalance = Double.parseDouble(String.valueOf(current.getText()));
//        savingsbalance = Double.parseDouble(String.valueOf(savings.getText()));
//} else {
//    Toast.makeText(TransferAccountActivity.this, "Could not fetch user details", Toast.LENGTH_LONG).show();
//}
////onclicklistener for the transfer button
//transfer.setOnClickListener(new View.OnClickListener(){
//    @Override public void onClick(View view){
//        //check if transfer amount is entered
//        if (!TextUtils.isEmpty(transferamount.getText())) {
//            //get value from edittext
//        transfer_amount = Double.parseDouble(String.valueOf(transferamount.getText()));
//        //check which item was selected from spinner
//        spinnerchoice = transferoption.getSelectedItemPosition();
//        switch (spinnerchoice) {
//            case 0:
//                //transfer from current to savings
//        // check if amount entered is less than balance in the current account
//        if (transfer_amount <= currentbalance) {
//            //withdraw amount from current balance
//        new currentbalance = currentbalance -transfer_amount;
//        //update textview with new current balance
//        current.setText(String.valueOf(newcurrentbalance));
//                }
//        }
////convert double to string
//newcurbal = Double.toString(newcurrentbalance);
//        //deposit money into savings account
//        newsavingsbalance = savingsbalance + transfer_amount;
//        //update textview with new savings balance
//        savings.setText(String.valueOf(newsavingsbalance));
//        //convert double to string
//        newsavbal = Double.toString(newsavingsbalance);
//        //update database with new current and savings balance
//        sqliteHelper.updateBalance(new BankUserDetails(null, null, null, email, null, null, null, newcurbal, newsavbal));
//        //show message that transfer was successful
//        Toast.makeText(TransferAccountActivity.this, "Transfer completed successfully", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(TransferAccountActivity.this, "Error: Insufficient funds. Please enter alower transfer amount and try again.", Toast.LENGTH_LONG).show();
//        }
//        break;
//        case 1:
//            //transfer from savings to current//
//        // check if amount entered is less than balance in the savings account
//        if (transfer_amount <= savingsbalance) {
//            //withdraw amount from savings balance
//            newsavingsbalance = savingsbalance -transfer_amount;
//            //update textview with new savings balance
//            savings.setText(String.valueOf(newsavingsbalance));
//            //convert double to string
//            newsavbal = Double.toString(newsavingsbalance);
//            //deposit money into current account
//            newcurrentbalance = currentbalance + transfer_amount;
//            //update textview with new current balance
//            current.setText(String.valueOf(newcurrentbalance));
//            //convert double to string
//            newcurbal = Double.toString(newcurrentbalance);
//            //update database with new current and savings balance
//            sqliteHelper.updateBalance(new BankUserDetails(null, null, null, email, null, null, null, newcurbal, newsavbal));
//});
//
