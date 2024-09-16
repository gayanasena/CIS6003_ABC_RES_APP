<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>ABC Restaurant - Home</title>
    <meta name="description" content="">
    <meta name="keywords" content="">

    <!-- Favicons -->
    <link href="Assets/logo_abc.png" rel="icon">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com" rel="preconnect">
    <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Satisfy:wght@400&display=swap" rel="stylesheet">

    <!-- Vendor CSS -->
    <link href="Assets/Vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="Assets/Vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="Assets/Vendor/aos/aos.css" rel="stylesheet">
    <link href="Assets/Vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="Assets/Vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Main_Client_Page CSS -->
    <link href="CSS/dashboard_main.css" rel="stylesheet">
</head>

<body class="index-page">
<%
    String query_status = request.getParameter("query_status");
%>
<script>
    // Check if the parameters are not null or empty before showing the alert
    <% if (query_status != null && !query_status.isEmpty()) { %>
    alert('Thank you for your feedback,  <%= query_status %>');
    <% } %>
</script>
<header id="header" class="header fixed-top">
    <div class="branding d-flex align-items-cente">

        <div class="container position-relative d-flex align-items-center justify-content-between">
            <a href="client_main.jsp" class="logo d-flex align-items-center">
                <h1 class="sitename">ABC Restaurants</h1>
            </a>

            <nav id="navmenu" class="navmenu">
                <ul>
                    <li><a href="#home" class="active">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#menu">Menu</a></li>
                    <li><a href="#accommodation">Accommodation</a></li>
                    <li><a href="#events">Events</a></li>
                    <li><a href="#gallery">Gallery</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <a href="login.jsp" class="cta-btn">Log in</a>
                </ul>
                <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
            </nav>

        </div>

    </div>

</header>

<main class="main">

    <!-- Home Section -->
    <section id="home" class="home section dark-background">

        <div id="carousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">

            <div class="carousel-item active">
                <img src="Assets/img/backgrounds/b1.jpg" alt="">
                <div class="carousel-container">
                    <h2><span>
            ABC </span> Restaurant</h2>
                    <p>ABC Restaurant is a family business, with over 20 years of experience in the industry. We want to offer you an experience in Asian flavors.
                        With us we have a la carte, catering solutions and take away. In addition, we also have banqueting rooms that you can book for courses and conferences, or for other special events.
                        The restaurant is centrally located on Strømmen, close to Strømmen Storsenter</p>
                    <div>
                        <a href="#menu" class="btn-get-started">Our Menu</a>
                        <a href="#reservation" class="btn-get-started">Making a Reservation</a>
                    </div>
                </div>
            </div><!-- End Carousel Item -->

            <div class="carousel-item">
                <img src="Assets/img/backgrounds/b5.jpg" alt="">
                <div class="carousel-container">
                    <h2>Culture Bridge</h2>
                    <p>Our restaurant is an exquisite combination between eastern culinary culture and the taste of Europeans in general and Norway in particular.
                        Here we expect that there is not only a restaurant, but also a connection between Eastern and Western culture, the connection between tradition and modernity.</p>
                    <div>
                        <a href="#menu" class="btn-get-started">Our Menu</a>
                        <a href="#reservation" class="btn-get-started">Making a Reservation</a>
                    </div>
                </div>
            </div><!-- End Carousel Item -->

            <div class="carousel-item">
                <img src="Assets/img/backgrounds/b3.jpg" alt="">
                <div class="carousel-container">
                    <h2>Our Vision</h2>
                    <p>Our specialty lies in crafting a culinary experience that is both unique and memorable. We take pride in fusing time-honored traditions with contemporary techniques, using the freshest ingredients to create dishes that tell a story. Each plate is a reflection of our commitment to excellence, innovation, and a deep respect for the flavors that define our identity.</p>
                    <div>
                        <a href="#menu" class="btn-get-started">Our Menu</a>
                        <a href="#reservation" class="btn-get-started">Making a Reservation</a>
                    </div>
                </div>
            </div><!-- End Carousel Item -->

            <a class="carousel-control-prev" href="#carousel" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
            </a>

            <a class="carousel-control-next" href="#carousel" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
            </a>

            <ol class="carousel-indicators"></ol>

        </div>

    </section><!-- /home Section -->

    <!-- About Section -->
    <section id="about" class="about section light-background">

        <div class="container">

            <div class="row gy-4">
                <div class="col-lg-6 position-relative align-self-start" data-aos="fade-up" data-aos-delay="100">
                    <img src="Assets/img/backgrounds/b4.jpg" class="img-fluid" alt="">
                    <a href="https://www.youtube.com/watch?v=NSMV4YcdFEE" class="glightbox pulsating-play-btn"></a>
                </div>
                <div class="col-lg-6 content" data-aos="fade-up" data-aos-delay="200">
                    <h3>It`s all about ABC Restaurant</h3>
                    <p class="fst-italic">
                        ABC Restaurant is a family business, with over 20 years of experience in the industry. We want to offer you an experience in Asian flavors.
                        With us we have a la carte, catering solutions and take away. In addition, we also have banqueting rooms that you can book for courses and conferences, or for other special events.
                        The restaurant is centrally located on Strømmen, close to Strømmen Storsenter.
                    </p>
                    <ul>
                        <li><i class="bi bi-check2-all"></i> <span>Fusion Cuisine: ABC Restaurant offers a unique blend of traditional and modern culinary styles, creating innovative dishes that cater to a wide range of tastes.</span></li>
                        <li><i class="bi bi-check2-all"></i> <span>Inviting Ambiance: The restaurant's atmosphere combines cultural elements with contemporary design, providing a warm and welcoming environment for diners.</span></li>
                        <li><i class="bi bi-check2-all"></i> <span>Exceptional Service: ABC Restaurant is known for its attentive and friendly staff, ensuring that each guest has a memorable dining experience.</span></li>
                    </ul>
                </div>
            </div>

        </div>

    </section><!-- /About Section -->

    <!-- Menu Section -->
    <section id="menu" class="menu section">

        <!-- Section Title -->
        <div class="container section-title" data-aos="fade-up">
            <h2>Menu</h2>
            <div><span>Check Our Tasty</span> <span class="description-title">Menu</span></div>
        </div><!-- End Section Title -->

        <div class="container isotope-layout" data-default-filter="*" data-layout="masonry" data-sort="original-order">

            <div class="row" data-aos="fade-up" data-aos-delay="100">
                <div class="col-lg-12 d-flex justify-content-center">
                    <ul class="menu-filters isotope-filters">
                        <li data-filter="*" class="filter-active">All</li>
                        <li data-filter=".filter-starters">Fride Rice & Briryani</li>
                        <li data-filter=".filter-salads">Sawan</li>
                        <li data-filter=".filter-specialty">Specialty</li>
                    </ul>
                </div>
            </div><!-- Menu Filters -->

            <div class="row isotope-container" data-aos="fade-up" data-aos-delay="200">

                <div class="col-lg-6 menu-item isotope-item filter-starters">
                    <img src="Assets/img/menu/Chicken-Fried-Rice-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Chicken Fried Rice</a><span>Rs.1,500.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Chicken, Vegetable Chopsuey, Chilli Paste
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-specialty">
                    <img src="Assets/img/menu/Chicken-Biriyani-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Chicken Biriyani</a><span>Rs.1,200.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Fried Chicken, Fried Boiled Egg, Mint Sambol, Raita Salad
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-starters">
                    <img src="Assets/img/menu/Chicken-Lamprais-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Chicken Lumprais</a><span>Rs.1,550.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Chicken, Kaliya Curry, Cutlet, Fried Boiled Egg, Blachan, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-salads">
                    <img src="Assets/img/menu/Fish-Fried-Rice-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Fish Fried Rice</a><span>Rs.1,250.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Fish, Vegetable Chopsuey, Chilli Paste
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-specialty">
                    <img src="Assets/img/menu/Seafood-Lamprais-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Seafood Lamprais</a><span>Rs.1,625.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Fish, Prawn & Cuttlefish, Kaliya Curry, Cutlet, Fried Boiled Egg, Blachan, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-starters">
                    <img src="Assets/img/menu/Vegetable-Biriyani-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Vegetable Biriyani</a><span>Rs.1,275.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Vegetable Mixed Rice, Mint Sambol, Raita Salad, Vegetable Cutlet
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-salads">
                    <img src="Assets/img/menu/Vegetable-Fried-Rice-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Vegetable Fried Rice</a><span>Rs.1,150.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Hot Butter Mushroom, Vegetable Chopsuey, Chilli Paste
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-specialty">
                    <img src="Assets/img/menu/Mutton Sawan.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Mutton Sawan</a><span>Rs.13,200.00 – Rs.20,700.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Chicken & Mutton, Kaliya Curry, Cutlet, Fried Boiled Egg, Blachan, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-specialty">
                    <img src="Assets/img/menu/Prawn-Nasi.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Prawn Sawan</a><span>Rs.12,200.00 – Rs.15,700.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Prawn, Kaliya Curry, Cutlet, Fried Boiled Egg, Blachan, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-specialty">
                    <img src="Assets/img/menu/Chicken-Nasi.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Chicken Sawan</a><span>Rs.9,800.00 – Rs.16,700.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Chicken, Kaliya Curry, Cutlet, Fried Boiled Egg, Blachan, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->

                <div class="col-lg-6 menu-item isotope-item filter-salads">
                    <img src="Assets/img/menu/Vegetable-Lamprais-2048x1365.jpg" class="menu-img" alt="">
                    <div class="menu-content">
                        <a href="#">Vegetable Lamprais</a><span>Rs.1,300.00</span>
                    </div>
                    <div class="menu-ingredients">
                        Kaliya Curry, Vegetable Cutlet, Potato Tempered, Hot Butter Mushroom, Seeni Sambol
                    </div>
                </div><!-- Menu Item -->



            </div><!-- Menu Container -->

        </div>

    </section>
    <!-- /Menu Section -->

    <!-- Accommodation Section -->
    <section id="accommodation" class="accommodation section">

        <!-- Section Title -->
        <div class="container section-title" data-aos="fade-up">
            <h2>accommodation</h2>
            <div><span>Check Our</span> <span class="description-title">accommodation</span></div>
        </div><!-- End Section Title -->

        <div class="container" data-aos="fade-up" data-aos-delay="100">

            <div class="row">
                <div class="col-lg-3">
                    <ul class="nav nav-tabs flex-column">
                        <li class="nav-item">
                            <a class="nav-link active show" data-bs-toggle="tab" href="#accommodation-tab-1">Superior King</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="tab" href="#accommodation-tab-2">Superior Twin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="tab" href="#accommodation-tab-3">Superior Room</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="tab" href="#accommodation-tab-4">Executive Room</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="tab" href="#accommodation-tab-5">Presidential Room</a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-9 mt-4 mt-lg-0">
                    <div class="tab-content">
                        <div class="tab-pane active show" id="accommodation-tab-1">
                            <div class="row">
                                <div class="col-lg-8 details order-2 order-lg-1">
                                    <h3>Superior King</h3>
                                    <div class="row-occupancy">
                                        <img src="Assets/img/occu_logo.png" alt="">
                                        <p class="fst-italic">Occupancy 2 Adults</p>
                                    </div>
                                    <p>Superior King is a luxurious abode designed to cater to the exquisite tastes befitting a king</p>
                                </div>
                                <div class="col-lg-4 text-center order-1 order-lg-2">
                                    <img src="Assets/img/accommodation/Superior-King-Thumbnail-Image.jpg" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="accommodation-tab-2">
                            <div class="row">
                                <div class="col-lg-8 details order-2 order-lg-1">
                                    <h3>Superior Twin</h3>
                                    <div class="row-occupancy">
                                        <img src="Assets/img/occu_logo.png" alt="">
                                        <p class="fst-italic">Occupancy 2 Adults</p>
                                    </div>
                                    <p>Offering seamless views, the Superior Twin is thoughtfully designed</p>
                                </div>
                                <div class="col-lg-4 text-center order-1 order-lg-2">
                                    <img src="Assets/img/accommodation/Superior-Twin.jpg" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="accommodation-tab-3">
                            <div class="row">
                                <div class="col-lg-8 details order-2 order-lg-1">
                                    <h3>Superior Room</h3>
                                    <div class="row-occupancy">
                                        <img src="Assets/img/occu_logo.png" alt="">
                                        <p class="fst-italic">Occupancy 2 Adults</p>
                                    </div>
                                    <p>Designed to provide maximum comfort for discerning travelers</p>
                                </div>
                                <div class="col-lg-4 text-center order-1 order-lg-2">
                                    <img src="Assets/img/accommodation/Superior-Room_1.jpg" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="accommodation-tab-4">
                            <div class="row">
                                <div class="col-lg-8 details order-2 order-lg-1">
                                    <h3>Executive Room</h3>
                                    <div class="row-occupancy">
                                        <img src="Assets/img/occu_logo.png" alt="">
                                        <p class="fst-italic">Occupancy 2 Adults</p>
                                    </div>
                                    <p>Ideal for business travelers looking for a relaxing stay in the city</p>
                                </div>
                                <div class="col-lg-4 text-center order-1 order-lg-2">
                                    <img src="Assets/img/accommodation/Executive-Suite-room.jpg" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="accommodation-tab-5">
                            <div class="row">
                                <div class="col-lg-8 details order-2 order-lg-1">
                                    <h3>Presidential Room</h3>
                                    <div class="row-occupancy">
                                        <img src="Assets/img/occu_logo.png" alt="">
                                        <p class="fst-italic">Occupancy 2 Adults</p>
                                    </div>
                                    <p>A luxurious room designed with comfort and elegance in mind</p>
                                </div>
                                <div class="col-lg-4 text-center order-1 order-lg-2">
                                    <img src="Assets/img/accommodation/presidential-room.jpg" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </section><!-- /accommodation Section -->

    <!-- Events Section -->
    <section id="events" class="events section">

        <img class="slider-bg" src="Assets/img/backgrounds/b2.jpg" alt="" data-aos="fade-in">

        <div class="container">

            <div class="swiper init-swiper" data-aos="fade-up" data-aos-delay="100">
                <script type="application/json" class="swiper-config">
                    {
                        "loop": true,
                        "speed": 600,
                        "autoplay": {
                            "delay": 5000
                        },
                        "slidesPerView": "auto",
                        "pagination": {
                            "el": ".swiper-pagination",
                            "type": "bullets",
                            "clickable": true
                        }
                    }
                </script>
                <div class="swiper-wrapper">

                    <div class="swiper-slide">
                        <div class="row gy-4 event-item">
                            <div class="col-lg-6">
                                <img src="Assets/img/backgrounds/b7.jpg" class="img-fluid" alt="">
                            </div>
                            <div class="col-lg-6 pt-4 pt-lg-0 content">
                                <h3>Evening tea party</h3>
                                <div class="price">
                                    <p><span>Rs.6,500.00</span></p>
                                </div>
                                <p class="fst-italic">
                                    An evening tea party is a relaxed, social gathering where guests enjoy tea, light snacks, and pleasant conversation, usually in the early evening.
                                </p>
                                <ul>
                                    <li><i class="bi bi-check2-circle"></i> <span> Often held outdoors or in cozy indoor spaces with decorative tableware.</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span> Finger foods like sandwiches, scones, pastries, and biscuits.</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span>Soft lighting, floral arrangements, and serene background music.</span></li>
                                </ul>
                                <p>
                                    Tea party is a refined social event, typically held at dusk, where guests enjoy tea, light bites, and casual conversation.
                                </p>
                            </div>
                        </div>
                    </div><!-- End Slider item -->

                    <div class="swiper-slide">
                        <div class="row gy-4 event-item">
                            <div class="col-lg-6">
                                <img src="Assets/img/backgrounds/b8.jpg" class="img-fluid" alt="">
                            </div>
                            <div class="col-lg-6 pt-4 pt-lg-0 content">
                                <h3>Dine with Romance</h3>
                                <div class="price">
                                    <p><span>Rs.8,500.00</span></p>
                                </div>
                                <p class="fst-italic">
                                    An evening beach dine is a serene dining experience by the ocean, where guests enjoy a meal with the backdrop of sunset views and the sound of waves.
                                </p>
                                <ul>
                                    <li><i class="bi bi-check2-circle"></i> <span>Dining by the sea with natural elements like sand and ocean breeze.</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span>Beautiful sunset serves as a stunning visual highlight.</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span>Fresh, coastal-inspired dishes often featuring seafood.</span></li>
                                </ul>
                                <p>
                                    An intimate beachside dinner offers a magical setting with the ocean breeze and starlit skies. The menu includes fresh seafood, grilled delicacies, and refreshing drinks, all enjoyed in a serene, seaside atmosphere.
                                </p>
                            </div>
                        </div>
                    </div><!-- End Slider item -->

                    <div class="swiper-slide">
                        <div class="row gy-4 event-item">
                            <div class="col-lg-6">
                                <img src="Assets/img/backgrounds/b9.jpg" class="img-fluid" alt="">
                            </div>
                            <div class="col-lg-6 pt-4 pt-lg-0 content">
                                <h3>The gourmet night</h3>
                                <div class="price">
                                    <p><span>Rs.12,500</span></p>
                                </div>
                                <p class="fst-italic">
                                    The Gourmet Night is an upscale dining experience, showcasing an exquisite multi-course menu crafted by top chefs. Guests savor premium ingredients, fine wines, and artfully presented dishes in a luxurious ambiance.
                                </p>
                                <ul>
                                    <li><i class="bi bi-check2-circle"></i> <span>Curated multi-course meals featuring gourmet ingredients.</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span>Dishes crafted by renowned or Michelin-starred chefs</span></li>
                                    <li><i class="bi bi-check2-circle"></i> <span>Fine wines expertly paired with each course.</span></li>
                                </ul>
                                <p>
                                    Offers an evening of culinary excellence, where each dish is a masterpiece of flavor and creativity.
                                </p>
                            </div>
                        </div>
                    </div><!-- End Slider item -->

                </div>
                <div class="swiper-pagination"></div>
            </div>

        </div>

    </section><!-- /Events Section -->

    <!-- reservation Section -->
    <section id="reservation" class="reservation section">

        <!-- Section Title -->
        <div class="container section-title" data-aos="fade-up">
            <h2>Reservation</h2>
            <div><span> Make your reservations with us</span>
            </div>
            <!-- End Section Title -->

            <div class="container align-items-center">

                <div class="row g-0 " data-aos="fade-up" data-aos-delay="100">

                    <div class="col-lg-4 reservation-img" style="background-image: url(Assets/img/reservation_form_img.png);"></div>

                    <div class="col-lg-8 align-items-center reservation-form-bg" data-aos="fade-up" data-aos-delay="200" >
                        <form action="reservation" method="post" role="form" class="php-email-form">
                            <div >
                                <div class="">
                                    <input type="text" name="name" class="form-control" id="name_client" placeholder="Your Name" required="">
                                </div>
                                <div class="">
                                    <input type="email" class="form-control" name="email" id="email_client" placeholder="Your Email" required="">
                                </div>
                                <div class="">
                                    <input type="text" class="form-control" name="phone" id="phone" placeholder="Your Phone" required="">
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <select class="form-control" id="reservation-type" name="reservationType" required>
                                    <option value="" disabled selected>Select Reservation Type</option>
                                    <option value="lunch">Lunch</option>
                                    <option value="dinner">Dinner</option>
                                    <option value="room">Rooms</option>
                                    <option value="event">Event</option>
                                </select>
                            </div>
                            <div class="form-group mt-3">
                                <select class="form-control" id="sub-reservation-type" name="reservationSubType" required>
                                    <option value="" disabled selected>Select an Option</option>
                                    <option value="superiorKing">Superior King</option>
                                    <option value="superiorTwin">Superior Twin</option>
                                    <option value="superiorRoom">Superior Room</option>
                                    <option value="executiveRoom">Executive Room</option>
                                    <option value="presidentialRoom">Presidential Room</option>
                                    <option value="chickenFriedRice">Chicken Fried Rice - Rs.1,500.00</option>
                                    <option value="chickenBiriyani">Chicken Biriyani - Rs.1,200.00</option>
                                    <option value="chickenLumprias">Chicken Lumprias - Rs.1,550.00</option>
                                    <option value="fishFriedRice">Fish Fried Rice - Rs.1,250.00</option>
                                    <option value="seafoodLumprias">Seafood Lumprias - Rs.1,625.00</option>
                                    <option value="vegetableBiriyani">Vegetable Biriyani - Rs.1,275.00</option>
                                    <option value="vegetableFriedRice">Vegetable Fried Rice - Rs.1,150.00</option>
                                    <option value="muttonSawan">Mutton Sawan - Rs.13,200.00 – Rs.20,700.00</option>
                                    <option value="prawnSawan">Prawn Sawan - Rs.12,200.00 – Rs.15,700.00</option>
                                    <option value="chickenSawan">Chicken Sawan - Rs.9,800.00 – Rs.16,700.00</option>
                                    <option value="vegetableLumprias">Vegetable Lumprias - Rs.1,300.00</option>
                                    <option value="dineWithRomance">Dine with Romance - Rs.8,500.00</option>
                                    <option value="theGourmetNight">The Gourmet Night - Rs.12,500.00</option>
                                    <option value="eveningTeaParty">Evening Tea Party - Rs.6,500.00</option>
                                </select>
                            </div>
                            <div class="form-group mt-3">
                                <input type="number" class="form-control" name="guestCount" id="guest_count" placeholder="Number of Guests" required="">
                            </div>
                            <div class="form-group mt-3">
                                <input type="datetime-local" class="form-control" name="reservationDate" id="date_time" required="">
                            </div>
                            <div class="form-group mt-3">
                                <textarea class="form-control" name="message" rows="6" placeholder="Message"></textarea>
                            </div>

                            <div class="text-center ">
                                <button type="submit">Send Reservation</button>
                            </div>
                        </form>
                    </div><!-- End Reservation Form -->

                </div>

            </div>
        </div>

    </section><!-- /reservation Section -->

    <!-- Gallery Section -->
    <section id="gallery" class="gallery section">

        <!-- Section Title -->
        <div class="container section-title" data-aos="fade-up">
            <h2>Gallery</h2>
            <div><span>Some photos from</span> <span class="description-title">Our Restaurant</span></div>
        </div><!-- End Section Title -->

        <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">

            <div class="row g-0">

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-1.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-1.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-2.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-2.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-3.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-3.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-4.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-4.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-5.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-5.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-6.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-6.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-7.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-7.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

                <div class="col-lg-3 col-md-4">
                    <div class="gallery-item">
                        <a href="Assets/img/gallery/gallery-8.jpg" class="glightbox" data-gallery="images-gallery">
                            <img src="Assets/img/gallery/gallery-8.jpg" alt="" class="img-fluid">
                        </a>
                    </div>
                </div><!-- End Gallery Item -->

            </div>

        </div>

    </section><!-- /Gallery Section -->

    <!-- Contact Section -->
    <section id="contact" class="contact section">

        <!-- Section Title -->
        <div class="container section-title" data-aos="fade-up">
            <h2>Contact</h2>
            <div><span>Check Our</span> <span class="description-title">Contact</span></div>
        </div><!-- End Section Title -->

        <div class="mb-5">
            <iframe style="width: 100%; height: 400px;" src= "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3959.8592076341065!2d79.8995728!3d7.025830600000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae2f79fd1f2e697%3A0xda27847f43d1c135!2sChurch%20street%2C%20Welisara!5e0!3m2!1sen!2slk!4v1725857636347!5m2!1sen!2slk" frameborder="0" allowfullscreen=""></iframe>
        </div><!-- End Google Maps -->

        <div class="container" data-aos="fade">

            <div class="row gy-5 gx-lg-5">

                <div class="col-lg-4">

                    <div class="info">
                        <h3>Get in touch</h3>
                        <p>We’d love to hear from you! Whether you have questions, feedback, or need more information about our menu, events, or reservations, feel free to reach out. Let’s make your next visit unforgettable!</p>

                        <div class="info-item d-flex">
                            <i class="bi bi-geo-alt flex-shrink-0"></i>
                            <div>
                                <h4>Location:</h4>
                                <p>Church Street, Welisara, Negombo</p>
                            </div>
                        </div><!-- End Info Item -->

                        <div class="info-item d-flex">
                            <i class="bi bi-envelope flex-shrink-0"></i>
                            <div>
                                <h4>Email:</h4>
                                <p>info@abcrestaurents.com</p>
                            </div>
                        </div><!-- End Info Item -->

                        <div class="info-item d-flex">
                            <i class="bi bi-phone flex-shrink-0"></i>
                            <div>
                                <h4>Call:</h4>
                                <p>+94 319 559 955</p>
                            </div>
                        </div><!-- End Info Item -->

                    </div>

                </div>
                <div class="col-lg-8">
                    <form action="query" method="post" class="php-email-form">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <input type="text" name="name" class="form-control" id="full_name" placeholder="Your Name" required="">
                            </div>
                            <div class="col-md-6 form-group mt-3 mt-md-0">
                                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" required="">
                            </div>
                        </div>
                        <div class="form-group mt-3">
                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" required="">
                        </div>
                        <div class="form-group mt-3">
                            <textarea class="form-control" name="message" placeholder="Message" required=""></textarea>
                        </div>
                        <div class="text-center">
                            <button type="submit">Send Message</button>
                        </div>
                    </form>
                </div><!-- End Contact Form -->

            </div>

        </div>

    </section><!-- /Contact Section -->

</main>

<footer id="footer" class="footer dark-background">

    <div class="container">
        <div class="row gy-3">
            <div class="col-lg-3 col-md-6 d-flex">
                <i class="bi bi-geo-alt icon"></i>
                <div class="address">
                    <h4>Address</h4>
                    <p>Church Street,</p>
                    <p>Welisara,</p>
                    <p>Negombo</p>
                    <p></p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 d-flex">
                <i class="bi bi-telephone icon"></i>
                <div>
                    <h4>Contact</h4>
                    <p>
                        <strong>Phone:</strong> <span>+94 319 559 955</span><br>
                        <strong>Email:</strong> <span>info@abcrestaurents.com</span><br>
                    </p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 d-flex">
                <i class="bi bi-clock icon"></i>
                <div>
                    <h4>Opening Hours</h4>
                    <p>
                        <strong>Mon-Sat:</strong> <span>11AM - 11PM</span><br>
                        <strong>Sunday</strong>: <span>8AM - 12PM</span>
                    </p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6">
                <h4>Follow Us</h4>
                <div class="social-links d-flex">
                    <a href="#" class="twitter"><i class="bi bi-twitter-x"></i></a>
                    <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                    <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                    <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>

        </div>
    </div>

    <div class="container copyright text-center mt-4">
        <p>© <span>Copyright</span> <strong class="px-1 sitename">ABC Restaurants</strong> <span>All Rights Reserved</span></p>
    </div>

</footer>

<!-- Scroll Top -->
<a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Preloader -->
<div id="preloader"></div>

<!-- Vendor JS Files -->
<script src="Assets/Vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="Assets/Vendor/aos/aos.js"></script>
<script src="Assets/Vendor/glightbox/js/glightbox.min.js"></script>
<script src="Assets/Vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="Assets/Vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="Assets/Vendor/swiper/swiper-bundle.min.js"></script>

<!-- Main JS File -->
<script src="Assets/js/main.js"></script>

</body>

</html>
