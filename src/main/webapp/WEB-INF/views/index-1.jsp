	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Welcome to Pollinater</title>
		
		  <link href="/resources/css/bootstrap.css" rel="stylesheet">
	      
	      <link href="/resources/css/pollinater-style.css" rel="stylesheet">
	      <link href="/resources/css/menu.css" rel="stylesheet">
	      <link href="/resources/css/pop-up.css" rel="stylesheet">
	      <link href="/resources/css/footer.css" rel="stylesheet">
	      <link rel="stylesheet" href="/resources/css/half-slider.css" />

         
	      <script type="text/javascript" src="/resources/js/jquery-1.10.2.js"></script>
          <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
    	  
		  
          <script type="text/javascript" src="/resources/js/jquery.easy-pie-chart.min.js"></script>


    

	</head>

	<body>

		<header>

			<!-- Upper navigation Starts -->
			<div class="top-nav-bg">

			 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#about">ABOUT POLLINATER </a></li>
                    <li><a href="#services">SUBMIT PROJECTS </a></li>
                    <li><a href="#contact">RAISE FUNDING</a></li>
                    <li><a href="">CONTACT US</a></li>
                    <li class="dropdown">
                         <a href="#" class="dropdown-toggle" data-toggle="dropdown"><font color="#83b964">MY ACCOUNT <b class="caret"></b></font></a>
                              <ul class="dropdown-menu">
                          <li><a href="#"><img src="/resources/images/favourite-icon.png" alt="" /> <span>Your Favorites</span></a></li>
                          <li><a href="#"><img src="/resources/images/shopping-cart-icon.png" alt="" /> <span>Shopping Cart (#)</span></a></li>
                          <li><a href="#"><img src="/resources/images/settings.png" alt="" /> <span>Settings</span></a></li>
                          <li><a href="#"><img src="/resources/images/logout-icon.png" alt="" /> <span>Log Out</span></a></li>
                        </ul>
                    </li>
                </ul>
			</div>

            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
   		 </nav>
		</div>


			<!-- sign up form starts -->
		<a id="signup_form" class="overlay" href="#x"></a>
		<div class="box">

	<h2>Sign up for pollinater - It's free</h2>
	<h3>Lorem ipsum dolor sit amet, conse elit laoreet dolore magna aliquam erat volutpat.</h3>

	<div class="divider"><hr/></div>
    <!--    Start "join with facebook" and "twitter", you can delete if you don't like it -->
	<div class="connectwith">
		<input type="submit" value="" class="fb">
       
	</div> 

	<div class="line-txt"> <div class="line-mid-txt">or</div> </div>
    <!-- end of "join with facebook" and "twitter"  -->
    	<input type="text" placeholder="Enter email address" class="text-field email">
    	<input type="password" placeholder="Create Password" class="text-field pass">
    	<input type="password" placeholder="Confirm Password" class="text-field pass">
		
    	<input type="button" class="signup" value=""><br>
    	<p><label><font size="2px">By signing up, you agree to the <a href="#">terms of use</a> and <a href="#">privacy policy</a></font></a></label></p><br><br/>
    	<div class="lower-bg"><p><font size="2px">Have an account? <a href="#login_form" id="logintop">Sign In</a></font></p>
    	</div>
        <a href="#close" class="close"></a>

	</div>

		<!-- sign up form ends -->

		<!-- login starts -->
			

			<a id="login_form" class="overlay" href="#x"></a>
		<div class="box">
	<h2>Sign in to your account</h2>

	<div class="divider"><hr/></div>

       <input type="text" placeholder="Enter email address" class="text-field email">
       <input type="password" placeholder="Create Password" class="text-field pass">
       	<div id="buttons">  <input type="button" class="red" value="">
		</div>
		<div class="forgot-pass"><a href="#">Forgot Your Password?</a></div>

		<div class="line-txt"> <div class="line-mid-txt">or</div> </div>

		

    	<a href="#close" class="close"></a>
<!-- error state it is not visible because: visibility:hidden -->
<!--    Start "join with facebook" and "twitter", you can delete if you don't like it -->
	<div class="connectwith">
		<input type="submit" value="" class="fb">
        
	</div><br/>

	<div class="lower-bg"><p><font size="2px">No account? <a href="#signup_form" id="jointop">Sign up</a></font></p>
    	</div>
<!-- end of "join with facebook" and "twitter"  -->
   <div class="error">
   <div class="errortext">Incorrect login or password</div>
   </div>
<!--end of error state -->
  
</div>

		<!-- login ends -->
		<!-- Upper navigation Ends -->
		


		<!-- Lower Navigation Starts -->

			<div class="low-nav-bg">

				<div class="main-container">

					<div class="logo-bg">
					<div class="logo"><a href="index.html"><img src="/resources/images/pollinater-logo.png" alt="pollinater logo"></a></div>
          			</div>
                             
          			<div class="right-nav">
          				

          				<nav>
						<ul id="menu-nav">
							
							<li id="link1"><a href="">REWARD-BASED</a></li>
                            <li id="link2"><a href="">DONATION-BASED</a></li>
                            <li id="link3"><a href="">SHOP PRODUCTS</a></li>
						</nav>

          				<form class="navbar-form navbar-left" role="search">
						  <div class="form-group">
						    <input type="text" class="form-control" placeholder="Search projects and products">
						  </div>
  						</form> 



          			</div>

				</div>

			</div>

		<!-- Lower Navigation Ends -->

			
		</header>
		<!-- /header -->




		<!-- banner starts -->

		<div class="banner">
			
			<div id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class=""></li>
            <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="2" class=""></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item">
                <div class="fill" style="background-image:url('images/pollinater-banner.png');"></div>
                <div class="carousel-caption">
                    <h1>Discover and compare 23,746 crowdfunding projects.<br/>
On one website.</h1>
                </div>
                <div class="carousel-caption1">
                    <h2>Support the children affected by the tsunami in Peru</h2>
                </div>
            </div>
            <div class="item active">
                <div class="fill" style="background-image:url('images/pollinater-banner.png');"></div>
                <div class="carousel-caption">
                     <h1>Discover and compare 23,746 crowdfunding projects.<br/>
On one website.</h1>
                </div>
                <div class="carousel-caption1">
                    <h2>Support the children affected by the tsunami in Peru</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('images/pollinater-banner.png');"></div>
                <div class="carousel-caption">
                    <h1>Discover and compare 23,746 crowdfunding projects.<br/>
On one website.</h1>
                </div>
                 <div class="carousel-caption1">
                    <h2>Support the children affected by the tsunami in Peru</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </div>

		</div>


		<!-- banner ends -->

		<!-- mid panel starts -->

		<div class="mid-panel">
			<div class="container">

			<div class="mid-row">
				<div class="mid-left-panel">
					<div class="headRow1">REWARDS-BASED: TRENDING</div>
				</div>
				<div class="mid-right-panel">
					<div class="headRow2"><a href="">See More</a></div>
				</div>

			</div>

				<!-- boxes starts -->
				<div class="row">

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">

                            <div class="mid-panel-img"><a href=""><img src="/resources/images/reward-based-image.jpg" alt=""> </a></div>

                            <div class="caption">
                                <div class="headRow3"><a href="">REWARD-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                	<div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="50" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">50</span>%<canvas height="75" width="75"></canvas></div>   
                                    </div>
                                	<div class="fund-bg">
                                		<div class="fund-main-bg">
                                			<div class="fund-txt">Funded</div>
                                			<div class="fund-amt">$20,000</div>
                                		</div>

                                		<div class="fund-main-bg">
                                			<div class="fund-txt">Goal</div>
                                			<div class="fund-amt">$40,000</div>
                                		</div>

                                		<div class="fund-main-bg1">
                                			<div class="fund-txt">Ends</div>
                                			<div class="fund-amt">25 Days</div>
                                		</div>

                                	</div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/icon.png"><span> Fundable</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>

                           
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                           <div class="mid-panel-img"><a href=""><img src="/resources/images/reward-based-image1.jpg" alt=""></a></div>
                           <div class="caption">
                                <div class="headRow3"><a href="">REWARD-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                        <div data-color="#81c37f" data-percent="25" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">25</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/icon.png"> <span>Fundable</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>

                           
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/reward-based-image2.jpg" alt=""></a></div>
                            <div class="caption">
                                <div class="headRow3"><a href="">REWARD-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="125" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">125</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Get Funded-icon.png"> <span>Get Funded</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon1.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/reward-based-image3.jpg" alt=""></a>
                            <div class="label-icon"><img src="/resources/images/ending-soon-icon.png" alt=""></div>
                            <div class="label-icon1"><img src="/resources/images/trending-icon.png" alt=""></div>

                            </div>
                             <div class="caption">
                                <div class="headRow3"><a href="">REWARD-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="75" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">75</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Kickstarter-icon.png"> <span>Kickstarter</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon1.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                  

                </div>

                <!-- boxes ends -->
			</div>

		</div>

		<!-- mid panel ends -->




<!-- mid panel starts -->

		<div class="mid-panel">
			<div class="container">

			<div class="mid-row">
				<div class="mid-left-panel">
					<div class="headRow1">DONATION-BASED: TRENDING</div>
				</div>
				<div class="mid-right-panel">
					<div class="headRow2"><a href="">See More</a></div>
				</div>

			</div>

				<!-- boxes starts -->
				<div class="row">

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">

                            <div class="mid-panel-img"><a href=""><img src="/resources/images/donation-based-image.jpg" alt=""></a></div>

                             <div class="caption">
                                <div class="headRow4"><a href="">DONATION-BASED · DISASTER RELIEF </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="50" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">50</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Crowdrise-icon.png" align="absmiddle"> <span>Crowdrise</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                           <div class="mid-panel-img"><a href=""><img src="/resources/images/donation-based-image1.jpg" alt=""></a></div>
                          <div class="caption">
                                <div class="headRow4"><a href="">DONATION-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="25" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">25</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Gofundme-icon.png"><span> Gofundme</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/donation-based-image2.jpg" alt=""></a></div>
                             <div class="caption">
                                <div class="headRow4"><a href="">SPONSORED · DONATION · TECHNOLOGY  </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="125" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">125</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Razoo-icon.png"><span> Razoo</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/donation-based-image3.jpg" alt=""></a></div>
                            <div class="caption">
                                <div class="headRow4"><a href="">DONATION-BASED · TECHNOLOGY </a></div>
                                <div class="project-title">Lorem Ipsum Dolor Sit Amit Consectetu</div>
                                <div class="comp-loct"><a href="">Company · Location</a></div>

                                <!-- percentage bar -->
                                <div class="percentage-bg">
                                    <div class="circle-bg">
                                         <div data-color="#81c37f" data-percent="75" class="easy-pie-chart percentage easyPieChart" style="width: 75px; height: 75px; line-height: 75px; color: rgb(129, 195, 127);"><span class="percent">75</span>%<canvas height="75" width="75"></canvas></div>
                                    </div>
                                    <div class="fund-bg">
                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Funded</div>
                                            <div class="fund-amt">$20,000</div>
                                        </div>

                                        <div class="fund-main-bg">
                                            <div class="fund-txt">Goal</div>
                                            <div class="fund-amt">$40,000</div>
                                        </div>

                                        <div class="fund-main-bg1">
                                            <div class="fund-txt">Ends</div>
                                            <div class="fund-amt">25 Days</div>
                                        </div>

                                    </div>

                                </div>
                                <!-- percentage bar ends -->
                                <div class="cls"></div>
                                 <div class="lower-box">
                            <div class="icon-text"><img src="/resources/images/Fundly-icon.png"> <span>Fundly</span></div>
                            <div class="icon-box"><img src="/resources/images/heart-icon.png"></div>
                               
                            </div>
                            </div>
                        </div>
                    </div>

                  

                </div>

                <!-- boxes ends -->
			</div>

		</div>

		<!-- mid panel ends -->





        <!-- mid panel starts -->

        <div class="mid-panel">
            <div class="container">

            <div class="mid-row">
                <div class="mid-left-panel">
                    <div class="headRow1">TRENDING PRODUCTS</div>
                </div>
                <div class="mid-right-panel">
                    <div class="headRow2"><a href="">See More</a></div>
                </div>

            </div>

                <!-- boxes starts -->
                <div class="row">

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">

                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image.jpg" alt=""></a></div>

                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                           <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image1.jpg" alt=""></a></div>
                          <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image2.jpg" alt=""></a></div>
                             <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image3.jpg" alt=""></a></div>
                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>


                     <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image4.jpg" alt=""></a></div>
                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>


                     <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image5.jpg" alt=""></a></div>
                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>


                     <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image6.jpg" alt=""></a></div>
                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>


                     <div class="col-lg-3 col-md-6 hero-feature">
                        <div class="thumbnail">
                            <div class="mid-panel-img"><a href=""><img src="/resources/images/trending-product-image7.jpg" alt=""></a></div>
                            <div class="caption1">
                               

                                <!-- percentage bar -->
                                <div class="icon-text1"> Lorem ipsum text</div>
                            <div class="icon-box1">$99.99</div>
                                <!-- percentage bar ends -->
                                
                            </div>
                        </div>
                    </div>

                  

                </div>

                <!-- boxes ends -->
            </div>

        </div>

        <!-- mid panel ends -->


		

		<!-- footer starts -->

		<div class="subfooter">



		<div class="container">
			<aside class="tuts-network">
				<h4>Discover Projects</h4>
				<ul>
			    <li><a href="" class="psdtuts">Reward-Based</a></li>
					<li><a href="" class="psdtuts">Donation-Based</a></li>
					<li><a href="" class="psdtuts">Shop Crowdfunded Products</a></li>
			  </ul>
			</aside>

			<aside class="tuts-network">
				<h4>Learn More</h4>
				<ul>
					<li><a href="" class="psdtuts">How it Works</a></li>
					<li><a href="" class="psdtuts">Submit Project(s) to Our Site</a></li>
					<li><a href="" class="psdtuts">Raise Funding for Your Project</a></li>
				</ul>
			</aside>
			
			<aside class="tuts-network">
				<h4>Partner With Us</h4>
				<ul>
					<li><a href="" class="psdtuts">Crowdfunding Platforms</a></li>
					<li><a href="" class="psdtuts">Crowdfunded Products</a></li>
					<li><a href="" class="psdtuts">Others</a></li>  					
				</ul>
			</aside>

			<aside class="tuts-network">
				<h4>Follow Us</h4>
				<ul>
					<li><a href="" class="social-icon"><img src="/resources/images/fb-icon.png"/></a></li>
					<li><a href="" class="social-icon"><img src="/resources/images/twitter-icon.png"/></a></li>
					<li><a href="" class="social-icon"><img src="/resources/images/p-icon.png"/></a></li>  					
				</ul>
			</aside>
			</div>
	
		</div>


		<!-- footer ends -->


		<footer>
		<div class="container">
		<div class="foot-border">
		<nav>
			<ul id="demo-nav">
				
				<li><a href="">Contact Us<span class="sep">•</span></a></li>
                <li><a href="">Privacy Policy<span class="sep">•</span></a></li>
                <li><a href="">Terms and Conditions</a></li>
			</ul>
		</nav>

		<div class="container">
			<p class="credit">© 2014 Pollinater, LLC</p>
		</div>

		</div>
		</div>
	</footer>

		<!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    $(document).ready(function(){
    // $(".hellozz").hover(
    //     alert('han v ');
    // });
});

   // var oldie = $.browser.msie && $.browser.version < 9;
    $('.easy-pie-chart').each(function(){
        console.log(this);
        $(this).easyPieChart({
            barColor: $(this).data('color'),
            trackColor: '#eaeaea',
            scaleColor: false,
            lineCap: 'butt',
            lineWidth: 8,
            animate: 1000,
            size:65
        }).css('color', $(this).data('color'));
    });
    </script>


<!-- for magento theme starts -->

<script type="text/javascript">
    /*<![CDATA[*/
    jQuery(document).ready(function ($) {
        //$("#nav").magentoBootstrapNavigation();
    });
    /*]]>*/
</script>

<!-- magento theme ends -->

	</body>
	</html>
