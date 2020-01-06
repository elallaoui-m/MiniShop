<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Sign In</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <jsp:include page="layouts/links.jsp"/>
  </head>
  <body class="goto-here">

  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	  <div class="container">
		  <a class="navbar-brand" href="home">Minishop</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="oi oi-menu"></span> Menu
		  </button>
	  </div>
  </nav>



  <div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
	  <div class="container">
		  <div class="row no-gutters slider-text align-items-center justify-content-center">
			  <div class="col-md-9 ftco-animate text-center">
				  <h1 class="mb-0 bread">Sign In</h1>
			  </div>
		  </div>
	  </div>

	  <section class="text-center ftco-section contact-section bg-light">
		  <div class="container  text-center centered">

			  <div class="row block-9">
				  <div class="col-md-6 offset-md-3">
					  <form action="Login" class="bg-white p-5 contact-form">
						  <div class="form-group">
							  <input name="email" type="text" class="form-control" placeholder="Email">
						  </div>
						  <div class="form-group">
							  <input name="pass"  type="password" class="form-control" placeholder="Password">
						  </div>
						  <div class="form-group">
							  <input type="submit" value="Login" class="btn btn-primary py-3 px-5">
							  <a href="#" class="btn btn-primary py-3 px-5">Create New Account</a>
						  </div>
					  </form>

				  </div>
			  </div>
		  </div>
	  </section>
  </div>



    <jsp:include page="layouts/footer.jsp"/>
    <jsp:include page="layouts/scripts.jsp"/>
    
  </body>
</html>