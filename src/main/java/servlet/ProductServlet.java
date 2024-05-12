private void editProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Créez une instance de ProductDAO
        ProductDAO productDAO = new ProductDAO();

        // Obtenez le produit à modifier en fonction de son ID
        Product product = productDAO.getProductById(productId);

        // Si le produit existe, envoyez-le à la page de modification
        if (product != null) {
            // Définissez l'attribut "product" dans l'objet request
            request.setAttribute("product", product);

            // Redirigez vers la page JSP editProduct.jsp
            request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
        } else {
            // Si le produit n'existe pas, envoyez une erreur 404
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Le produit avec l'ID spécifié n'existe pas.");
        }
    } catch (NumberFormatException e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de produit invalide");
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
