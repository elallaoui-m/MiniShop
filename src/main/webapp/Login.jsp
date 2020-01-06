<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Sign In</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <jsp:include page="layouts/links.jsp"/>
  </head>
  <body class="goto-here" style="background: goldenrod"	>
  <div class="py-1 bg-black">
	  <div class="container">
		  <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
			  <div class="col-lg-12 d-block">
				  <div class="row d-flex">
					  <div class="col-md pr-4 d-flex topper align-items-center">
						  <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						  <span class="text">+212-606-123-456</span>
					  </div>
					  <div class="col-md pr-4 d-flex topper align-items-center">
						  <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
						  <span class="text">youremail@email.com</span>
					  </div>

				  </div>
			  </div>
		  </div>
	  </div>
  </div>
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	  <div class="container">
		  <a class="navbar-brand" href="home">Minishop</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="oi oi-menu"></span> Menu
		  </button>
	  </div>
  </nav>

	  <section class="text-center ftco-section contact-section bg-light" >
		  <div class="container  text-center centered">
			  <div class="row block-9">
				  <div class="col-md-6 offset-md-3">
					  <h1 class="mb-0 bread">Sign In</h1>
					  <form action="Login" method="post" class="bg-white p-5 contact-form">
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