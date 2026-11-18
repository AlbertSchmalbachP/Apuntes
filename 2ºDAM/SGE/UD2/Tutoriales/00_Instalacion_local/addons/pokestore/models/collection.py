from odoo import fields, models


class PokeStoreCollection(models.Model):
    _name = "pokestore.collection"
    _description = "Colección PokeStore"
    _order = "name"

    name = fields.Char(string="Nombre", required=True)
    generation = fields.Integer(string="Generación")
    release_date = fields.Date(string="Fecha de lanzamiento")
    active = fields.Boolean(default=True)
    figure_ids = fields.One2many(
        "pokestore.figure",
        "collection_id",
        string="Figuras",
    )
