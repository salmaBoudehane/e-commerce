<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier le produit</title>
    <!-- Insérez ici vos liens vers les fichiers CSS ou d'autres ressources -->
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Modifier le produit
                    </div>
                    <div class="card-body">
                        <form action="ProductServlet" method="post">
                            <div class="form-group">
                                <label for="id">ID:</label>
                                <input type="text" id="id" name="id" class="form-control" value="${product.id}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="name">Nom:</label>
                                <input type="text" id="name" name="name" class="form-control" value="${product.name}" required>
                            </div>
                            <div class="form-group">
                                <label for="imageUrl">URL de l'image:</label>
                                <input type="text" id="imageUrl" name="imageUrl" class="form-control" value="${product.imageUrl}" required>
                            </div>
                            <div class="form-group">
                                <label for="price">Prix:</label>
                                <input type="text" id="price" name="price" class="form-control" value="${product.price}" required>
                            </div>
                            <div class="form-group">
                                <label for="description">Description:</label>
                                <textarea id="description" name="description" class="form-control" required>${product.description}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="marque">Marque:</label>
                                <input type="text" id="marque" name="marque" class="form-control" value="${product.marque}" required>
                            </div>
                            <button type="submit" name="action" value="edit" class="btn btn-primary">Modifier</button>
                            <!-- Ajoutez ici un bouton pour annuler la modification si nécessaire -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Insérez ici vos liens vers les fichiers JavaScript ou d'autres ressources -->
</body>
</html>
