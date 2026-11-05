from odoo import fields, models

class PokestoreTag(models.Model):
    _name = "Tag"
    _description = "Etiquetas para cada figura."
    
    name = fields.Char(string="Nombre", required=True)
    