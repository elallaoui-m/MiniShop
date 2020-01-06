<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rand" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <jsp:include page="layouts/links.jsp"/>
</head>
<body class="goto-here">
<jsp:include page="layouts/head_nav.jsp">
    <jsp:param  name="nbr" value="cc"/>
</jsp:include>



    <div id="home" class="hero-wrap hero-bread" style="background: aquamarine">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="home">Home</a></span> <span>Shop</span></p>
            <h1 class="mb-0 bread">Shop</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section bg-light">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-8 col-lg-10 order-md-last">
    				<div class="row">
						<c:forEach items="${articles}" var="article">
							<div class="col-sm-12 col-md-6 col-lg-3 ftco-animate d-flex">
								<div class="product d-flex flex-column">
									<a href="SingleProduct?code=<c:out value="${article.codeArticle}"/>" class="img-prod"><img class="img-fluid" src="images/product-<c:out value="${article.codeArticle %  8  + 1}"/>.png" alt="Colorlib Template">
										<div class="overlay"></div>
									</a>
									<div class="text py-3 pb-4 px-3">
										<div class="d-flex">
											<div class="cat">
												<span><c:out value="${article.categorieByIdCat.catName}"/></span>
											</div>
											<div class="rating">
												<p class="text-right mb-0">
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
												</p>
											</div>
										</div>
										<h3><a href="#"><c:out value="${article.designation}"/></a></h3>
										<div class="pricing">
											<p class="price"><span><fmt:formatNumber value = "${article.prix}" type = "currency"/></span></p>
										</div>
										<p class="bottom-area d-flex px-3">
											<a href="AddToCart?code=<c:out value="${article.codeArticle}"/>" class="add-to-cart text-center py-2 mr-1"><span>Add to cart <i class="ion-ios-add ml-1"></i></span></a>
												<%--<a href="#" class="buy-now text-center py-2">Buy now<span><i class="ion-ios-cart ml-1"></i></span></a>--%>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
		    		</div>
		    	</div>

		    	<div class="col-md-4 col-lg-2">
		    		<div class="sidebar">
							<div class="sidebar-box-2">
								<h2 class="heading">Categories</h2>
								<div class="fancy-collapse-panel">
                  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

					  <c:forEach items="${categories}" var="cat">
						 			  <a d href="home?f=<c:out value="${cat.idCat}"/>" aria-expanded="true" aria-controls="collapseOne">
										  <c:out value="${cat.catName}"/>
									  </a><br>
					  </c:forEach>


                  </div>
               </div>
							</div>

						</div>
    			</div>
    		</div>
    	</div>
    </section>
		

	<jsp:include page="layouts/footer.jsp"/>

	<jsp:include page="layouts/scripts.jsp"/>
  </body>
</html>