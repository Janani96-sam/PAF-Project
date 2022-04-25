<!doctype html>
<html lang="en">

 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Calculate Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/libs/css/style.css">
    <link rel="stylesheet" href="../../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
</head>

<body>
    <!-- ============================================================== -->
    <!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">
         <!-- ============================================================== -->
        <!-- navbar -->
        <!-- ============================================================== -->
         <jsp:include page="../common/sidebar.jsp" />
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="container-fluid  dashboard-content">
                <!-- ============================================================== -->
                <!-- pageheader -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title">Calculate Bill Details</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Calculate bill details</a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader -->
                <!-- ============================================================== -->
             
                    <div class="row">
                        <!-- ============================================================== -->
                        <!-- validation form -->
                        <!-- ============================================================== -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                          <form class="needs-validation" id="bill_form"> 
                            <div class="card">
                                <h5 class="card-header">Calculate Bill Details</h5>
                                <div class="card-body">
                                    
                                        <div class="row">
                                             <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom01">Customer</label>
                                                <select class="form-control" id="cus" onchange="check_cus(this.value)">
                                                	<option value="0">Select Customer</option>
                                                	<option  value="1">Janith Sameera</option>
                                                </select>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Bill Number</label>
                                                <input type="text" class="form-control" id="bill_no" placeholder="Bill Number"  required disabled>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Date</label>
                                                <input type="date" class="form-control" id="date" onchange="change_month()"  placeholder="Enter This Month Meter Reading"  required>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Month</label>
                                                <input type="text" class="form-control" id="month" placeholder="Month"  required disabled>
                                            </div>
                                            
                                           <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Unit Price</label>
                                                <input type="text" class="form-control" id="unit_price" placeholder="Unit Price"  required>
                                            </div>
                                           
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Unit Consumed</label>
                                                <input type="text" class="form-control" id="unit" placeholder="Unit consumed"  required>
                                            </div>
                                            
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                            	
                                               <!--  <label for="validationCustom02">Calculate</label> -->
                                                
                                            </div>
                                            
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                            	<button class="btn btn-danger" type="button" onclick="validate_cal()">Calculate</button>
                                            </div>
                                        </div>
                                </div>
                            </div>
                            
                        </form> 
                        </div>
                    </div>
                    
                    
                    <div class="row">
                        <!-- ============================================================== -->
                        <!-- validation form -->
                        <!-- ============================================================== -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <form class="needs-validation" id="addForm">
                            <div class="card">
                                <h5 class="card-header">Electricity Bill  Details</h5>
                                <div class="card-body">
                                    
                                        <div class="row">
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <label for="validationCustom02">Total Amount </label>
                                                <input type="text" class="form-control" id="amount" style="color:red;" placeholder="Amount"  disabled>
                                            </div>
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                            	<button class="btn btn-primary" onclick="save_amount()" type="button">Pay Amount</button>
                                            </div>
                                        </div>
                                </div>
                            </div>
                            
                            </form>
                        </div>
                    </div>
                     
                     
           
            </div>
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <jsp:include page="../common/footer.jsp" />
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="../../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="../../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="../../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="../../assets/vendor/parsley/parsley.js"></script>
    <script src="../../assets/libs/js/main-js.js"></script>
 <script src="../../js/custom/bill/add_bill.js"></script>
    <script src="../../js/custom/validation.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script>
//contact number validation
  function IsNumeric(e) {
      var keyCode = e.which ? e.which : e.keyCode
      var ret = ((keyCode >= 48 && keyCode <= 57));
      return ret;
  }
  </script>
</body>
 
</html>