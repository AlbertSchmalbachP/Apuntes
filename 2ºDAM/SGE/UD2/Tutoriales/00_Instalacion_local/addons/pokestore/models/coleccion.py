from odoo import fields, models  # pyright: ignore[reportMissingImports]

class PokestoreColeccion(models.Model):
    _name = "pokestore.coleccion"
    _description = "Colección de figuras"
    
    name = fields.Char(string="Nombre", required=True)
    generation = fields.Integer(string="Generación", default=1)
    launch_date = fields.Date(string="Fecha de lanzamiento", required=True)
    active = fields.Boolean(default=True)
    
    figure_ids = fields.One2many(
        "pokestore.figure",
        "collection_id",
        string="Figuras",
    )